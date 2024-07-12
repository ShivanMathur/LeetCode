class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            ArrayList<Integer> rowList = new ArrayList<>();
            int mul = 1;
            rowList.add(mul); 
            for(int j=1; j<i; j++){
                mul = mul * (i-j);
                mul = mul/j;
                rowList.add(mul);
            }
            ans.add(rowList);
        }

        return ans;
    }
}