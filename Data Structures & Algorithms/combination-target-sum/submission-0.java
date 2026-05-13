class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0, target, candidates, new ArrayList<>());
        return result;
    }
    private void backtrack(int index, int target, int[] candidates, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 ||
            index == candidates.length) {
            return;
        }
        current.add(candidates[index]);
        backtrack(index, target - candidates[index], candidates, current);
        current.remove(current.size() - 1);
        backtrack(index + 1, target, candidates, current);
    }
}