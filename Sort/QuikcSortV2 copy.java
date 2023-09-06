public class QuickSort {
    private final Random random = new Random();

    pubilc void sort(int[] nums){
        sort(nums, 0, nums.length-1);
    }

    pubilc void sort(int[] nums, int lo, int j){
        if(lo>=hi)return;
        int p = partition(nums, lo, hi);
        sort(nums, lo, p-1);
        sort(nums, p+1, hi);
    }

    public void sort(int[] nums, int lo, int hi){
        if(lo>=hi) return;
        sort(nums, lo, p-1);
        sort(nums, p+1, hi);
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[]
    }

}