class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans=new int[nums.length-k+1];
        
        int left=0;
        int right=k-1;
        int[] freq= new int[51];
        for(int i=left;i<=right;i++)freq[nums[i]]++;
        ans[0]=find(freq,x); 
        
        int ind=1; 
        while(right<nums.length){
            right++; 
            if(right==nums.length)break;
            freq[nums[right]]++; 
            freq[nums[left]]--; 
            left++; 
            
            ans[ind++]=find(freq,x); 
        }
        return(ans);
    }
    private int find(int[] f, int x){
        
        int[] freq= new int[51]; 
        for(int i=0;i<51;i++) freq[i]=f[i];
        int[] nums=new int[51];
        for(int i=0;i<51;i++)nums[i]=i; 

       
        for(int i=1;i<51;i++){
            int key=freq[i];
            int numKey=nums[i];
            int j=i-1;
            while(j>=0 && freq[j]<=key){
                freq[j+1]=freq[j];
                nums[j+1]=nums[j];
                j--;
            }
            freq[j+1]=key;
            nums[j+1]=numKey;
        }
  
        int sum=0;
        for(int i=0;i<x;i++){ 
            sum+=(nums[i]*freq[i]); 
        }
        return(sum);
    }
}