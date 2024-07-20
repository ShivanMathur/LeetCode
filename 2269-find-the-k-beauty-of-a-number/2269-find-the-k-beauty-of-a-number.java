class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        int left_ptr = 0, right_ptr = 0;
        String snum = Integer.toString(num);

        System.out.println(snum);

        for (int i = 0; i < snum.length() - k + 1; i++) {
            int n = Integer.parseInt(snum.substring(i, i + k));
            if (n != 0 && num % n == 0) {
                count++;
            }
        }
        return count;
    }
}