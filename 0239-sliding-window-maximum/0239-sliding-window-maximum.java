class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[n-k+1];
        int count = 0;

        for(int i=0; i<n; i++){
            
            // 1. When new element comes, nums[i], make space for it (Window Size can't be greater than k) 
            while(!deque.isEmpty() && deque.getFirst() <= i-k){
                deque.removeFirst();
            }

            // 2. Now, when nums[i] comes, there is no need to keep small elements in that window, pop them
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }

            // 3. Now push i in deque -> for nums[i]
            deque.addLast(i);

            // 4. If (i >= k-1), then deque.getFront() is our answer for that window
            if(i >= k-1){
                result[count++] = nums[deque.peek()];
            }
        }

        return result;
    }
}