class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        /* Approach 2: Greedy Approach
            TC: O(n)
            SC: O(1)
        */

        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;

        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        int result = 0;
        totalCost = 0;

        for(int i=0; i<n; i++){
            totalCost = totalCost + gas[i] - cost[i];
            
            if(totalCost < 0){
                totalCost = 0;
                result = i + 1;
            }
        }

        return result;
        
        /* Approach 1: Brute Force

        
        int n = gas.length;

        for(int i=0; i<n; i++){

            if(gas[i] < cost[i]){
                continue;
            }

            int j = (i+1) % n;
            int currGas = gas[i] - cost[i] + gas[j];

            while( j != i){
                if(currGas < cost[j]){
                    break;
                }

                int costForMovingFromCurrentStationj = cost[j];
                j = (j+1) % n;
                int gasEarnInNextStationj = gas[j];

                currGas = currGas - costForMovingFromCurrentStationj + gasEarnInNextStationj;
            }

            if(i == j){
                return i;
            }
        }

        return -1;
        */
    }
}