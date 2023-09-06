
public class FenwickTree {

    private int[] tree;
    private int len;

    public FenwickTree(int n) {
        this.len = n;
        tree = new int[n + 1];
    }


    public void update(int i, int delta) {
        while (i <= len) {
            tree[i] += delta;
            i += lowbit(i);
        }
    }


    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

}

// LC.215 https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/1879861/by-ac_oier-x9h4/