线段树可以解决区间和、区间最大值或区间最小值的问题（RMQ 问题），
不过线段树的代码量相对来说较大而且比较复杂，所以线段树是在前缀和、
差分和树状数组解决方法之后不得已才会考虑的方案。 
一般使用线段树的题目都具备 区间修改和区间查询 的特点，如果大家在这里是按照顺序刷的话，
应该对 RMQ 问题有一个比较充分的了解了，在这里做一下相关题型解法的归纳：

* 数组不变，区间查询：前缀和、树状数组和线段树
* 数组单点修改，区间查询：树状数组和线段树
* 数组区间修改，单点查询：差分和线段树
* 数组区间修改，区间查询：线段树
注意每种题型涉及的解法都是越靠前越优先考虑。