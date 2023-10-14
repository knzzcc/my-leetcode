
    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
        return a / gcd(a, b) * b;
    }


// LCM公式 LCM(a, b)=a/gcd(a,b)*b;
// => GCD(a, b)*LCM(a, b) = a * b

// Modular Arithmetic, Congruence

// 模運算性質
//     (a+b)%m=(a%m+b%m)%m
//     (a*b)%m=(a%m*b%m)%m
//     除法不具備分配律 -> 逆元，把除法變乘法，滿足分配律


// C/C++的%是求余运算，python的%是取模运算。所以C/C++要補償
// 模跟取餘
// x, y > 0; x mod m = y mod m  <- 同餘
// x < 0, y >= 0; x mod m + m = y mod m

// (x % m + m) % m  <- 負數取餘處理
// Math.floorMod(-1, 4) 也可以(for java)，或者正負數都統一用Math.floorMod
// https://www.cnblogs.com/doondo/p/14678204.html
// https://www.jiangmingtao.com/modulus-operation-of-int-type-in-java

// 同餘 (x−y) mod m = 0
// 逆元
//   拓展歐幾里得
//   費馬小定理 a^(p-1) = 1 (mod p) 
//     a, p互質
//     a^p%m a, p, m > 0
//     a^p=a^p-1 *a = 1 * a = a (mod p)
//     a^p%m=a%m "p很大的時候可以用" 

// 數論符號 https://blog.csdn.net/qq_62729874/article/details/127024387
// https://github.com/ThreeSR/LeetCode/blob/main/Subdocument/Math%20Theory.md

// https://applenob.github.io/algrithom/leetcode_python/

// https://zhuanlan.zhihu.com/p/635478302

// https://www.youtube.com/watch?v=LInNgWMtFEs
// ****
// https://hackmd.io/@nckuacm/NCKU-AdvCP-2021-Materials/https%3A%2F%2Fhackmd.io%2F%40D4nnyLee%2FNCKU-AdvCP-2021-Number-Theory
// https://www.desgard.com/algo/docs/part2/ch02/3-ext-euclidean/

// 周賽 珂朵莉
// LCA 樹上倍增
// https://leetcode.cn/circle/discuss/BzaVg8/
// https://chengzhaoxi.xyz/63dec3e.html

// 周賽 數論 組合 楊輝三角形 逆元 費馬小定理
// https://leetcode.cn/circle/discuss/vSxBlo/
// https://leetcode.cn/problems/count-k-subsequences-of-a-string-with-maximum-beauty/solutions/2424876/zu-he-shu-xue-pythonjavacgo-by-endlessch-whff/

// 周賽 離線算法
// https://leetcode.cn/circle/discuss/9n7Hnx/
// https://leetcode.cn/circle/discuss/rw1Mp3/

// 刷算法题必备的数学考点汇总
// https://zhuanlan.zhihu.com/p/301338035
// https://zhuanlan.zhihu.com/p/342610561
// https://chengzhaoxi.xyz/9c42293b.html

// 三分查找 三分搜 三分算法