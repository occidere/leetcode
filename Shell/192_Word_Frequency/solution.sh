#!/usr/local/bin/bash

# Make sure bash version over 4

declare -A WORD_COUNT
ARR=(`cat words.txt | tr ' ' '\n'`)

for WORD in "${ARR[@]}"
do
    WORD_COUNT["${WORD}"]=$((WORD_COUNT["${WORD}"] + 1))
done

for key in "${!WORD_COUNT[@]}"
do
    echo "$key ${WORD_COUNT[$key]}"
done |
sort -rn -k2
