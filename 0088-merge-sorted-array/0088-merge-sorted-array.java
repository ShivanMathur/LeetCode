class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0 && n!=0){
            for(int j=0;j<n;j++)
                nums1[j]=nums2[j];
            return;

        }
        int i, j, k;
        i = m-1; j = n-1;
        k = m + n -1;

        while (j>=0){
            if(i>=0 && nums1[i]>=nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
    }
}