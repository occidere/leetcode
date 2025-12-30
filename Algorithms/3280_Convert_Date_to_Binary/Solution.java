class Solution {
    public String convertDateToBinary(String date) {
        String[] arr = date.split("-");
        return "%s-%s-%s".formatted(toBinary(arr[0]), toBinary(arr[1]), toBinary(arr[2]));
    }

    private String toBinary(String s) {
        return Integer.toBinaryString(Integer.parseInt(s));
    }
}
