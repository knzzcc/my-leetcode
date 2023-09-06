
    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
        return a / gcd(a, b) * b;
    }


// LCM公式 LCM(a, b)=a/gcd(a,b)*b;
// => GCD(a, b)*LCM(a, b) = a * b

// 模運算性質
//     (a+b)%m=(a%m+b%m)%m
//     (a*b)%m=(a%m*b%m)%m
//     除法不具備分配律 -> 逆元，把除法變乘法，滿足分配律



// 模跟取餘
// x, y > 0; x mod m = y mod m
// x < 0, y >= 0; x mod m + m = y mod m
// (x % m + m) % m

// 同餘 (x−y) mod m = 0
// 逆元
//   拓展歐幾里得
//   費馬小定理 a^(p-1) = 1 (mod p) 
//     a, p互質
//     a^p%m a, p, m > 0
//     a^p=a^p-1 *a = 1 * a = a (mod p)
//     a^p%m=a%m "p很大的時候可以用" 

// 數論符號 https://blog.csdn.net/qq_62729874/article/details/127024387