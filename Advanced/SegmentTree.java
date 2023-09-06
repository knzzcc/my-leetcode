public class SegmentTreeDynamic {

    class Node {
        Node left, right;
        int val, add;
    }

    private int N = (int) 1e9;
    private Node root = new Node();

    //  [start, end] update [l, r] wihe val
    //  node最初為root，但會隨著遞迴會逐漸改變，[start, end]範圍也會改變，但[l, r] val不變
    public void update(Node node, int start, int end, int l, int r, int val) {

        // 越界，退化成單點更新，val * number of child node
        if (l <= start && end <= r) {
            node.val += (end - start + 1) * val;
            node.add += val;
            return ;
        }

        int mid = (start + end) >> 1;

        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);

    }

    public int query(Node node, int start, int end, int l, int r) {

        // 越界，直接return
        if (l <= start && end <= r) return node.val;

        int mid = (start + end) >> 1, ans = 0;

        // pushDown "leftNum", "rightNum"
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) ans += query(node.left, start, mid, l, r); //更新區間和"遞迴縮減區間[start, mid]"有重疊
        if (r > mid) ans += query(node.right, mid + 1, end, l, r); 
        
        return ans;

    }

    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    private void pushDown(Node node, int leftNum, int rightNum) {

        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;

        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;

        // 如果下推lazy tag，需要累加，當前節點歸零
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;

    }
}