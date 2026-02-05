class Solution {
    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        for (char c : target.toCharArray()) {
            char a = 'a';
            String prev = res.isEmpty() ? "" : res.get(res.size() - 1);
            res.add(prev + String.valueOf(a));
            while (a < c) {
                ++a;
                if (a > 'z') {
                    a = 'a';
                }
                res.add(prev + String.valueOf(a));
            }
        }
        return res;
    }
}
