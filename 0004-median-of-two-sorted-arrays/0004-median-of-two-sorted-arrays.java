class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        /* Approach 2: Better Approach: 
            Optimize the space complexity by getting rid of the third array (mergedArr) to store sorted elements

            TC: O()
            SC: O()
        */

        int n = nums1.length;
        int m = nums2.length;
        int i=0;
        int j=0;
        
        int size = n + m;

        int ind1 = size/2 - 1;
        int ind2 = size/2;

        int count = 0;
        int ind1Element = Integer.MIN_VALUE;
        int ind2Element = Integer.MIN_VALUE;

        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                if(count == ind1){
                    ind1Element = nums1[i];
                }
                if(count == ind2){
                    ind2Element = nums1[i];
                }
                count++;
                i++;
            }
            else{
                if(count == ind1){
                    ind1Element = nums2[j];
                }
                if(count == ind2){
                    ind2Element = nums2[j];
                }
                count++;
                j++;
            }
            if(ind1Element != Integer.MIN_VALUE && ind2Element != Integer.MIN_VALUE){
                break;
            }
        }

        while(i < n){
            if(count == ind1){
                ind1Element = nums1[i];
            }
            if(count == ind2){
                ind2Element = nums1[i];
            }
            count++;
            i++;
        }

        while(j < m){
            if(count == ind1){
                ind1Element = nums2[j];
            }
            if(count == ind2){
                ind2Element = nums2[j];
            }
            count++;
            j++;
        }

        if(size%2 == 1){
            return (double)(ind2Element);
        }

        return (double)( (ind1Element + ind2Element)/2.0);

        
        /* Approach 1: Brute Force : Merge nums1 & nums2 inta a new array
            TC: O(n+m)
            SC: O(n+m)

        int n = nums1.length;
        int m = nums2.length;

        int i = 0, j = 0, k = 0;

        int[] mergedArr = new int[n + m];

        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                mergedArr[k++] = nums1[i];
                i++;
            }
            else{
                mergedArr[k++] = nums2[j];
                j++;
            }
        }

        while(i < n){
            mergedArr[k++] = nums1[i++];
        }
        while(j < m){
            mergedArr[k++] = nums2[j++];
        }

        double median = 0.0;
        int size = n+m;
        if(size%2 == 0){
            median = (mergedArr[size/2 - 1] + mergedArr[size/2])/2.0;
        }
        else{
            median = mergedArr[size/2];
        }

        return median;
        */
    }
}