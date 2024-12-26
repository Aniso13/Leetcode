class Solution {
    public int maxNumberOfBalloons(String text) {
        int [] arr= new int [256];
        for(int i=0;i<text.length();i++)
            arr[text.charAt(i)]++;
        arr['l']/=2;
        arr['o']/=2;
        String texts="balloon";
        int small=arr['b'];
        for(int i=0;i<texts.length();i++){
            small=Math.min(small,arr[texts.charAt(i)]);
        }
        return small;
    }
}