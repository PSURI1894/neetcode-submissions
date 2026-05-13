class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, List<Integer> current){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int num : nums){
            if(current.contains(num)){
                continue;
            }
            current.add(num);
            backtrack(nums, current);
            current.remove(current.size() - 1);
        }
    }
}
