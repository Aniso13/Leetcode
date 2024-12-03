class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int sp = 0;    
        
        for (int i = 0; i < s.length(); i++) {
            if (sp < spaces.length && i == spaces[sp]) {
                str.append(" ");  
                sp++;       
            }
            str.append(s.charAt(i));    
        }
        
        return str.toString();
    }
}
