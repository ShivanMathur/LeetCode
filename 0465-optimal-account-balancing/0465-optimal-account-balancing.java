class Solution {
    public int minTransfers(int[][] transactions) {
        
        HashMap<Integer, Integer> creditMap = new HashMap<>();

        for(int i=0; i<transactions.length; i++){
            creditMap.put(transactions[i][0], creditMap.getOrDefault(transactions[i][0], 0) + transactions[i][2]);
            creditMap.put(transactions[i][1], creditMap.getOrDefault(transactions[i][1], 0) - transactions[i][2]);
        }

        List<Integer> balance_list = new ArrayList<>();

        for(int amount : creditMap.values()){
            if(amount != 0){
                balance_list.add(amount);
            }
        }

        return dfs(0, balance_list);
    }

    private int dfs(int index, List<Integer> balance_list){
        if(index == balance_list.size()){
            return 0;
        }

        int currBalance = balance_list.get(index);
        if(currBalance == 0){
            return dfs(index + 1, balance_list);
        }

        int cost = Integer.MAX_VALUE;

        for(int i = index + 1; i < balance_list.size(); i++){
            int next = balance_list.get(i);
            if( currBalance * next < 0){
                balance_list.set(i, currBalance + next);
                cost = Math.min(cost, 1 + dfs(index + 1, balance_list));
                balance_list.set(i, next);
                if(currBalance + next == 0){
                    break;
                }
            }
        }

        return cost;
    }
}