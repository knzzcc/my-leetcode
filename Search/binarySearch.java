    // 上左下右對應mid，上:mid向上取整，統一return l
    // not in range 上-1，下+1

    // 找第一次出現
    public int find_lower_bound(int l, int r){
        if (l < r) {
            int mid = l + r >> 1;
            if (inrange(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 找最後一次出現
    public int find_upeer_bound(int l, int r){
        if (l < r) {
            int mid = l + r + 1 >> 1;
            if (inrange(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }