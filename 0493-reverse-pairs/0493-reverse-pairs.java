class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        return mergeSort(nums, 0, nums.length-1);
    }

    public static int mergeSort(int[] nums, int low, int high){
        int count = 0;

        if(low >= high){
            return count;
        }

        int mid = low + (high-low)/2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public static int countPairs(int[] nums, int low, int mid, int high){
        int right = mid+1;
        int count = 0;

        for(int i=low; i<=mid; i++){
            while(right <=high && (long)nums[i] > 2*(long)nums[right]){
                right++;
            }
            count += (right - (mid+1));
        }

        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int left = low, right = mid+1;
        
        while(left <= mid && right <=high){
            if(nums[left] <= nums[right]){
                arrayList.add(nums[left]);
                left++;
            }
            else{
                arrayList.add(nums[right]);
                right++;
            }
        }
        
        while(left <= mid){
            arrayList.add(nums[left]);
            left++;
        }
        
        while(right <= high){
            arrayList.add(nums[right]);
            right++;
        }
        
        for(int i=low; i<=high; i++){
            nums[i] = arrayList.get(i-low);
        }
    }
}