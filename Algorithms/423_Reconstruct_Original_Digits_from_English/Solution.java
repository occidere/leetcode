class Solution {

    /*
    Approach: 각 숫자마다 고유 알파벳을 잡아서 카운팅 & 여러 숫자 내 중복된 알파벳 카운팅을 제외해줌

    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public String originalDigits(String s) {
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'z': ++cnt[0]; break;
                case 'o': ++cnt[1]; break; // 0, 1, 2, 4
                case 'w': ++cnt[2]; break; 
                case 'h': ++cnt[3]; break; // 3, 8
                case 'u': ++cnt[4]; break;
                case 'f': ++cnt[5]; break; // 4, 5
                case 'x': ++cnt[6]; break;
                case 'v': ++cnt[7]; break; // 5, 7
                case 'g': ++cnt[8]; break;
                case 'i': ++cnt[9]; break; // 5, 6, 8, 9
            }
        }
        cnt[1] -= cnt[0] + cnt[2] + cnt[4];
        cnt[3] -= cnt[8];
        cnt[5] -= cnt[4];
        cnt[7] -= cnt[5];
        cnt[9] -= cnt[5] + cnt[6] + cnt[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
