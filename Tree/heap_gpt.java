class Heap {
    int size = 0;
    int[] heap;

    public Heap(int len) {
        // 初始化堆数组，长度为 len+1，索引从 1 开始
        heap = new int[len + 1];
    }
    
    // 向堆中插入元素
    public boolean push(int val) {
        if (size == heap.length - 1) return false; // 堆已满，插入失败
        heap[++size] = val; // 插入到底部
        shiftUp(size); // 进行上浮操作
        return true;
    }

    // 弹出堆顶元素
    public int pop() {
        int val = heap[1]; // 获取堆顶元素
        heap[1] = heap[size]; // 将最后一个元素移到堆顶
        heap[size--] = 0; // 将最后一个位置置为0，size减少
        shiftDown(1); // 进行下沉操作
        return val; // 返回原堆顶元素
    }

    // 查看堆顶元素
    public int peek() {
        return heap[1]; // 返回堆顶元素
    }

    // 上浮操作
    private void shiftUp(int i) {
        int val = heap[i];
        while ((i >> 1) > 0) { // 当前节点还有父节点
            int parent = i >> 1; // 计算父节点索引
            if (val < heap[parent]) { // 如果当前节点值小于父节点值
                heap[i] = heap[parent]; // 父节点值下移
                i = parent; // 更新当前节点索引为父节点索引
            } else {
                break; // 不再需要上浮
            }
        }
        heap[i] = val; // 最终确定当前节点的位置
    }

    // 下沉操作
    private void shiftDown(int i) {
        int val = heap[i];
        while ((i << 1) <= size) { // 当前节点有子节点
            int child = i << 1; // 左子节点索引
            if (child != size && heap[child + 1] < heap[child]) {
                child++; // 右子节点存在且值更小，选择右子节点
            }
            if (val > heap[child]) { // 如果当前节点值大于最小的子节点值
                heap[i] = heap[child]; // 子节点上移
                i = child; // 更新当前节点索引为子节点索引
            } else {
                break; // 不再需要下沉
            }
        }
        heap[i] = val; // 最终确定当前节点的位置
    }
}
