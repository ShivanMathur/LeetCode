class Solution {
    public int totalFruit(int[] fruits) {
        
        // SLIDING WINDOW APPROACH || Dynamic Window variant with Auxilary data structure
        int maxFruits = 0, left = 0;
        Map<Integer, Integer> tree = new HashMap<>();

        for(int right = 0; right< fruits.length; right++){
            tree.put(fruits[right], tree.getOrDefault(fruits[right], 0) + 1);
            
            while(tree.size() > 2){
                tree.put(fruits[left], tree.get(fruits[left]) - 1);
                tree.remove(fruits[left], 0);
                left++;
            }
            maxFruits = Math.max(maxFruits, (right - left)+1);
        }

        return maxFruits;
    }
}