class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m){
            return false;
        }
        
        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        for(int i=0; i<n; i++){
            s1_freq[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;

        while(right < m){
            s2_freq[s2.charAt(right) - 'a']++;

            if(right - left + 1 > n){
                s2_freq[s2.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(s1_freq, s2_freq)){
                return true;
            }

            right++;
        }
        return false;
    }
}