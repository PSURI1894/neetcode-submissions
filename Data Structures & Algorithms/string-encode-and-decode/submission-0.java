class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
