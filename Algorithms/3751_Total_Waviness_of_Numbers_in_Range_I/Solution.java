class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for (int k = Math.max(100, num1); k <= num2; ++k) {
            var s = String.valueOf(k);
            int n = s.length() - 1;
            
            for (int i = 1; i < n; ++i) {
                var x = s.charAt(i - 1);
                var y = s.charAt(i);
                var z = s.charAt(i + 1);
                if ((x > y && y < z) || (x < y && y > z)) {
                    ++res;
                }
            }
        }
        return res;
    }
}
