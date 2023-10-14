public class extGcd {
    public static int[] extGcd(int a, int b) {
        if (b == 0) {
            return new int[] { a, 1, 0 };
        } else {
            int[] gcd = extGcd(b, a % b);
            return new int[] { gcd[0], gcd[2], gcd[1] - (a / b) * gcd[2] };
        }
    }

    public static void main(String[] args) {
        int[] gcd = extGcd(10, 15);
        System.out.println("gcd(10, 15) = " + gcd[0]);
        System.out.println("x = " + gcd[1]);
        System.out.println("y = " + gcd[2]);
    }
}

//int[] gcd = {gcd(a, b), x, y}
// Bezout 係數是兩個整數 a 和 b 的整數解 x 和 y 滿足Bezout等式 ax + by = gcd(a, b) 的係數
// gcd(10, 15) = 5
// x = -1
// y = 1

// 拓展歐幾里得算法可以用來解決以下問題：

// 求兩個數的最大公因數。 ✓
// 求兩個數的 Bezout 係數。 ✓
// 求兩個數的逆元。
//   如果 a 和 b 互質，則 gcd(a, b) = 1，因此Bezout等式可以化為 ax + by = 1。
// 求兩個數的最大公倍數。
//   lcm(a, b) = a * b / gcd(a, b)
// 求兩個數的素因子分解。 <- 複雜，真的有需要再問chatgpt