public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";

        for(int i=0; i<strs.size(); i++){
            String str = strs.get(i);
            int len = str.length();
            result += Integer.toString(len) + '#' + str;
        }

        return result;
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int n = s.length();

        int pos = 0;
        while(pos < n){
            int strLen = pos;
            while(s.charAt(strLen) != '#'){
                strLen++;
            }
            int len = Integer.parseInt(s.substring(pos, strLen));
            pos = strLen+1;
            result.add(s.substring(pos, pos+len));
            pos = pos + len;   
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));