class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return res;
    }
    private void backtrack(int start, String s, List<String> current){
        if(start == s.length()){
            res.add(new ArrayList<>(current));
            return;
        }       
        for(int end = start; end < s.length(); end++){
            if(ispalindrome(s, start, end)){
                current.add(s.substring(start, end + 1));
                backtrack(end + 1, s, current);
                current.remove(current.size() - 1);
            }
        }
    }
    private boolean ispalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }        
            left++;
            right--;
        }
        return true;
    }
}
