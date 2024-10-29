int removeDuplicates(int* nums, int numsSize) {
    int x = 1;
    for(int i=1; i<numsSize;i++)
    {
        if (i==numsSize-1)
            {
                nums[x++]=nums[i];
                break;
            }
        if(nums[i-1]!=nums[i+1])
            nums[x++]=nums[i];
    }
   
    return x;
}