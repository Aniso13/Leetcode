class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        
        int counter=1 ;
        word+=' ';
        
        for (int i =0;i<word.length()-1;i++){
            if (counter == 9){
                sb.append(counter);
                sb.append(word.charAt(i-1));
                if(word.charAt(i-1)==word.charAt(i))
                    counter = 0;
                else
                    counter=1;
            }
            if(word.charAt(i)==word.charAt(i+1))
                counter++;
            else
            {
                if(counter!=0){
                    sb.append(counter);
                    sb.append(word.charAt(i));
                
                    
                }
                counter = 1;
                    
            }
        }
        
        
        return sb.toString();
    }
}