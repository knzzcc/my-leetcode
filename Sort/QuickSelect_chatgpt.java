//todo測試一下 findKthLargest
public class QuickSelect {

    private final Random random = new Random();

    public int quickSelect(int[] nums, int k) {
        shuffle(nums);
        //chatgpt給k-1但似乎n-k才正確
        return quickSelect(nums, 0, nums.length - 1, k - 1); // k - 1 是因为数组索引从0开始
        return quickSelect(nums, 0, nums.length - 1, n - k); 
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) return nums[lo];

        int p = partition(nums, lo, hi);
        if (k == p) {
            return nums[k];
        } else if (k < p) {
            return quickSelect(nums, lo, p - 1, k);
        } else {
            return quickSelect(nums, p + 1, hi, k);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1, j = hi;

        while (i <= j) {
            while (i <= hi && nums[i] <= pivot) i++;
            while (j > lo && nums[j] > pivot) j--;

            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
