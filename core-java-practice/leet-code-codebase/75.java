class Solution {
    public void sortColors(int[] nums) {
       int n=nums.length;
       int i=0,j=0,k=n-1;
       while(j<=k){
        if(nums[j]==0){
            swap(nums,i,j);
            i++;
            j++;
        }else if(nums[j]==1){
            j++;
        }else{
            swap(nums,j,k);
            k--;
        }
       } 
    }
    static void swap(int[] nums,int l,int m){
        int temp=nums[l];
        nums[l]=nums[m];
        nums[m]=temp;
    }
}
