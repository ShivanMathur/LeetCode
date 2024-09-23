class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> zeroLoss = new HashSet<>();
        HashSet<Integer> oneLoss = new HashSet<>();
        HashSet<Integer> moreLoss = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<matches.length; i++){
            int winner = matches[i][0];
            int loser = matches[i][1];

            if(!oneLoss.contains(winner) && !moreLoss.contains(winner)){
                zeroLoss.add(winner);
            }

            if(zeroLoss.contains(loser)){
                oneLoss.add(loser);
                zeroLoss.remove(loser);
            }
            else if(oneLoss.contains(loser)){
                moreLoss.add(loser);
                oneLoss.remove(loser);
            }
            else if(moreLoss.contains(loser)){
                continue;
            }
            else{
                oneLoss.add(loser);
            }
        }

        List<Integer> l1 = new ArrayList<>(zeroLoss);
        List<Integer> l2 = new ArrayList<>(oneLoss);

        Collections.sort(l1);
        Collections.sort(l2);

        ans.add(l1);
        ans.add(l2);

        return ans;
    }
}