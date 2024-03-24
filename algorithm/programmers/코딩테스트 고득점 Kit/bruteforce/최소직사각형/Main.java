class Solution {
    public int solution(int[][] sizes) {

        List<Integer> widthList = new ArrayList<>(); // max
        List<Integer> heightList = new ArrayList<>(); // min

        for (int[] size : sizes) {
            widthList.add(Math.max(size[0], size[1]));
            heightList.add(Math.min(size[0], size[1]));
        }

        return Collections.max(widthList) * Collections.max((heightList));
    }
}