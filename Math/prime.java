    private List<Integer> getPrime(int n) {

        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];
        // 小於等於n的Prime
        for (int i = 2; i <= n; i++) {
            // 如果没有访问过，一定是素数
            if (!vis[i]) {
                ans.add(i);
                vis[i] = true;
            }

            for (int j = 0; j < ans.size(); j++) {
                int cur = ans.get(j);
                if (i * cur > n) break;
                vis[i * cur] = true;
                if (i % cur == 0) break;
            }
        }
        return ans;
    }
// 尤拉(線性篩)開n+1
// 沒vist過一定是
// 所有數都和所有已知質數(ans)相乘然後標記，沒訪問過的就是質數，直到指針走到底
// for ans 越界 break 
// vis[i*cur] = true 
// i%cur==0(之前就篩過) break
// ans裡面是遞增，i可以被cur整除，i*其他倍數一定會cur的倍數篩掉 brek j loop
// [3 5 7] 10%5=0 10*7可以分解5*2*7=> 未來14*5會篩掉

// 埃式
// 從i開始跳i格直到n，標記為false

// 甜姨
// 这题还有更好的筛法——线性筛，但不属于笔试/面试范畴，不需要掌握。
// 个人认为顶多出现在笔试题中，面试是不会问这么硬的数学题的。