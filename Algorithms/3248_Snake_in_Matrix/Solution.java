class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[] pos = new int[]{0, 0};
        Map<String, int[]> dir = new HashMap<>() {{
            put("UP", new int[]{-1, 0});
            put("RIGHT", new int[]{0, 1});
            put("DOWN", new int[]{1, 0});
            put("LEFT", new int[]{0, -1});
        }};
        for (String cmd : commands) {
            int[] dx = dir.get(cmd);
            pos[0] += dx[0];
            pos[1] += dx[1];
        }
        return pos[0] * n + pos[1];
    }
}
