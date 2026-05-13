class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>());
        return result;
    }
    private void backtrack(int start, int target, int[] candidates, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, current);
            current.remove(current.size() - 1);
        }
    }
}