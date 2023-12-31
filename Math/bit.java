    public static int lowbit(int x) {
        return x & (-x);
    }

    //去除最低位1
    //010001表示集合 記位，查詢

用lowbit运算统计1的个数

//極課大學 覃超算法訓練營
// x%2==1; x&1==1
// x%2==0; X&0==0

// x>>1
// lo - (lo - hi) >> 1 | (lo + hi + 1) >> 1



// 去除最低位的1
// x=x&(x-1)

// x&~x=0 判斷是否相等
---
交換律
a^b == b^a
結合律
(a^b)^c == a^(b^c))

A^0=A, A^A=0
==> 判斷是否相等 A^B==0

----
翻轉特定位

翻轉第0位 X ^1
0^1= 1 ; 1^1=0

----
以位元表示集合

000000000
000000101 (0, 2 used)

// 判斷第i位是否為1
((used >> i) & 1) == 1

// 將第i位標註為1
 used |= 1 << i;

// 將第i位標註為0
used ^= 1 << i;

https://leetcode.cn/circle/article/mDhWhf/

///
>>
<<
>>>

///
https://stackoverflow.com/questions/1472135/removing-lowest-order-bit  