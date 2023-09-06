class Heap {
    int size = 0;
    int[] heap;

    public Heap(int len) {
			heap = new int[len + 1];
    }
    //size "記錄現有大小"
    //放到現有的bottom，再shiftup
    public boolean push(int val) {
        if (size == heap.length - 1) return false;
        heap[++size] = val;
        shiftUp(size);
        return true;
    }

    //取出後，把tail放到head，tail設成0，size--，shiftDown(head)
    //為什麼要把tail放到head，因為這樣在調用shiftDown的同時
    //才可以把其他元素同時往下壓
    public int pop() {
        int val = heap[1];
        heap[1] = heap[size];
        heap[size--] = 0;
        shiftDown(1);
        return val;
    }

    public int peek() {
        return heap[1];
    }
    //i, l:2i, r:2i+1
    //i>>1(father) 大於0表示存在
    private void shiftUp(int i) {
        int val = heap[i];
        while ((i >> 1) > 0) {
	          int parent = i >> 1;
            if (val < heap[parent]) {
                heap[i] = heap[parent];
                i = parent;
            } else { break; }
        }
        heap[i] = val;
    }
    //<=size表示還沒越界，存在左子節點
    private void shiftDown(int i) {
        int val = heap[i];
        while ((i << 1) <= size) {
            int child = i << 1;
            //右子節點存在且更小
            if (child != size && heap[child + 1] < heap[child]) child++;
            if (val > heap[child]) {
                heap[i] = heap[child];
                i = child;
			} else { break; }
        }
        heap[i] = val;
    }
}

// 最為關鍵的一段
// child = i << 1;
// if (child != size && heap[child + 1] < heap[child]) child++;