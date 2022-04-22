#!/bin/bash

GITHUB_API_TOKEN="${1}"
LEETCODE_RANKING_LINE_CHANNEL_ACCESS_TOKEN="${2}"
LINE_BOT_ID="${3}"
USER_ID="${4}"

get_ranking_from_leetcode() {
  ranking=$(curl -sS -L -XPOST 'https://leetcode.com/graphql' \
    -H 'Content-Type: application/json' \
    -d "{
      \"query\": \"query userProfile(\$username: String!) { matchedUser(username: \$username) { profile { ranking } } }\",
      \"variables\": {
        \"username\": \"${1}\"
      }
    }" | jq '.data.matchedUser.profile.ranking')
  echo "$ranking"
}

get_ranking_from_github() {
  curl -sS -L -XGET 'https://raw.githubusercontent.com/occidere/leetcode/master/.statistics/leetcode_ranking.txt'
}

update_ranking_to_github() {
  ranking_file_url='https://api.github.com/repos/occidere/leetcode/contents/.statistics/leetcode_ranking.txt'
  base64_ranking=$(echo "${1}" | base64)
  sha=$(curl -sS -L -XGET "${ranking_file_url}" \
    -H 'Content-Type: application/json' \
    -H "Authorization: Bearer ${GITHUB_API_TOKEN}" | jq -cr '.sha')

  curl -sS -L -XPUT "${ranking_file_url}" \
    -H 'Content-Type: application/json' \
    -H "Authorization: Bearer ${GITHUB_API_TOKEN}" \
    -d "
    {
      \"message\": \"Update leetcode ranking\",
      \"content\": \"${base64_ranking}\",
      \"sha\": \"${sha}\"
    }
    "
}

send_line_notification() {
  prev_ranking=${1}
  curr_ranking=${2}
  ranking_changed=false
  msg=''

  if ((prev_ranking > curr_ranking)); then
    ranking_changed=true
    msg="Rank up ($prev_ranking -> $curr_ranking)"
  elif ((prev_ranking < curr_ranking)); then
    ranking_changed=true
    msg="Rank down ($prev_ranking -> $curr_ranking)"
  else
    msg="No change ($prev_ranking -> $curr_ranking)"
  fi

  echo "${msg}"
  if [ $ranking_changed == 'true' ]; then
    resp=$(
      curl -sS -L -XPOST 'https://api.line.me/v2/bot/message/push' \
        -H 'Content-Type: application/json' \
        -H "Authorization: Bearer ${LEETCODE_RANKING_LINE_CHANNEL_ACCESS_TOKEN}" \
        -d '{
        "to": "'"${LINE_BOT_ID}"'",
        "messages": [
          {
            "type": "text",
            "text": "'"${msg}"'"
          }
        ]
      }'
    )
    echo "Line sent response: $(echo "${resp}" | jq -cr .)"
  fi
}

main() {
  if [ "$#" -ne 4 ]; then
    echo 'Execution failed: 4 parameters required'
    echo '  (1) GITHUB_API_TOKEN'
    echo '  (2) LEETCODE_RANKING_LINE_CHANNEL_ACCESS_TOKEN'
    echo '  (3) LINE_BOT_ID'
    echo '  (4) USER_ID'
    exit 1
  fi

  ranking_from_github=$(get_ranking_from_github "${USER_ID}")
  echo "Ranking from github: $ranking_from_github"

  ranking_from_leetcode=$(get_ranking_from_leetcode "${USER_ID}")
  echo "Ranking from LeetCode: $ranking_from_leetcode"

  send_line_notification "${ranking_from_github}" "${ranking_from_leetcode}"
}

main "$@"
