    public double myPow(double x, int n) {

        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;

        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        //###
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        //###
        return res;
    }
    
// Java 代码中 int32 变量 n∈[−2147483648,2147483647] 
// 因此当 n=−2147483648 时执行 n=−n 会因越界而赋值出错。
// 解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。

