public class QuickSort {

    private final Random random = new Random();

    public void sort(int[] nums) {
        // 方法一：打乱
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {

        if (lo >= hi) return ;

        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {

        // 方法二：随机取
        int p = random.nextInt(hi - lo + 1) + lo;
        swap(nums, lo, p);
        int pivot = nums[lo];
        int i = lo + 1, j = hi;

        while (i <= j) {
            // while 结束后，[lo, i) 均 <= pivot
            while (i < hi && nums[i] <= pivot) i++;
            // while 结束后，(j, hi] 均 > pivot
            while (j > lo && nums[j] > pivot) j--;
          
            // ------ 若为降序，只需更改此处两行代码即可 ------
            // while (i < hi && nums[i] >= pivot) i++;
            // while (j > lo && nums[j] < pivot) j--;
            // ------------------- end -------------------
           
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void shuffle(int[] nums) {

        Random random = new Random();
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