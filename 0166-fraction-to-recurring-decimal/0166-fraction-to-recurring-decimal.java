class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        /* Approach 1: Mathslong Division
            TC: O()
            SC: O()
        */

        if(numerator == 0){
            return "0";
        }

        String sign = (numerator < 0) ^ (denominator < 0) ? "-" : "";

        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);

        long res = Math.abs(num / denom);
        
        String result = sign + Long.toString(res);
        
        long remainder = num % denom;

        if(remainder == 0){
            return result;
        }

        HashMap<Long, Integer> map = new HashMap<>();
        result += ".";

        while(remainder != 0){
            if(map.containsKey(remainder)){
                result = result.substring(0, map.get(remainder)) + "(" + result.substring(map.get(remainder)) + ")";
                break;
            }
            map.put(remainder, result.length());
            remainder = remainder*10;
            result += Long.toString(remainder / denom);
            remainder = remainder % denom;
        }

        return result;
    }
}