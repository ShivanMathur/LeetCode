class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<sortedArray.length; i++){
            if(!map.containsKey(sortedArray[i])){
                map.put(sortedArray[i], map.size()+1);
            }
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}