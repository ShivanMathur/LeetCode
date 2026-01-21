class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        /* Approach 3: Optimized Approach: Binary Search
            TC: O()
            SC: O()
        */

        int n = nums1.length;
        int m = nums2.length;

        // Perform the binary search approach on the smaller sized array to reduce time complexity
        if(n > m){
            findMedianSortedArrays(nums2, nums1);
        }

        int size = n + m;

        // Number of elements required on the left half array
        int left = (n + m + 1)/2;

        int low = 0, high = n;

        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n){
                r1 = nums1[mid1];
            }
            if(mid2 < m){
                r2 = nums2[mid2];
            }
            if(mid1 - 1 >=0){
                l1 = nums1[mid1 - 1];
            }
            if(mid2 - 1 >= 0){
                l2 = nums2[mid2 - 1];
            }

            if(l1 <= r2 && l2 <= r1){
                if(size % 2 == 1){
                    return Math.max(l1, l2);
                }
                else{
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2) )/2.0;
                }
            }
            else if(l1 > r2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }

        return 0;

        
        
        /* Approach 2: Better Approach: 
            Optimize the space complexity by getting rid of the third array (mergedArr) to store sorted elements

            TC: O(n+m)
            SC: O(1)


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
        */

        
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