class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] cnt = new int[26];
        for (String b: B) {
            int[] curCnt = getCnt(b);
            for (int i = 0; i < 26; ++i) {
                cnt[i] = Math.max(cnt[i], curCnt[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        outer: for (String a : A) {
            int[] curCnt = getCnt(a);
            for (int i = 0; i < 26; ++i) {
                if (curCnt[i] < cnt[i]) {
                    continue outer;
                }
            }
            ans.add(a);
        }

        return ans;
    }

    private int[] getCnt(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        return cnt;
    }
}
