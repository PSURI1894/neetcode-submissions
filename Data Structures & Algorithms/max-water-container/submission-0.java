class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while(left < right){
            int h = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = h * width;
            max = Math.max(max, area);
            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }        
        return max;
    }
}
