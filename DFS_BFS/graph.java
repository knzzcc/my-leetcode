package DFS_BFS;

public class graph {
    
}

// https://leetcode.cn/problems/all-paths-from-source-to-target/solutions/957447/tong-ge-lai-shua-ti-la-yi-ti-liang-jie-d-6764/

// 這裡一般都用AdjArray表達的方式
// 試著比較環檢測/topologist的題目 是Adj List和 Adj Array混用
// 二分圖就是array然後遞迴判斷會拿到前面，因為visited[i]visited相不相等做法不一樣
// 所以甚麼時候用AdjList甚麼時候用AdjArray

//稠密圖是指圖中的邊數接近最大可能的邊數。稠密圖通常用來表示具有大量邊的圖。
//有嚴謹的數學定義

/*

AdjList 和 AdjArray 是兩種常用的圖表示方式。AdjList 是用一個列表來表示圖中的每個頂點，列表中的元素是與該頂點相鄰的所有頂點。AdjArray 是用一個數組來表示圖中的每個頂點，數組中的元素是與該頂點相鄰的所有頂點的索引。

AdjList 和 AdjArray 各有優缺點。AdjList 的優點是：

可以用來表示任何圖，包括稀疏圖和稠密圖。
可以用來表示有向圖和無向圖。
可以用來表示有權值邊和無權值邊。
AdjList 的缺點是：

在存儲稠密圖時，會佔用較大的空間。
在遍歷圖時，需要遍歷每個頂點的所有相鄰節點。
AdjArray 的優點是：

在存儲稠密圖時，可以節省空間。
在遍歷圖時，可以直接訪問相鄰節點。
AdjArray 的缺點是：

只能用來表示稠密圖。
不能用來表示有向圖。
不能用來表示有權值邊。
選擇 AdjList 還是 AdjArray 取決於以下因素：

圖的稠密程度：如果圖是稠密圖，則 AdjList 會佔用較大的空間，而 AdjArray 可以節省空間。
圖的方向性：如果圖是有向圖，則 AdjList 可以用來表示，而 AdjArray 不能用來表示。
邊的權值：如果邊有權值，則 AdjList 可以用來表示，而 AdjArray 不能用來表示。
以下是一些使用 AdjList 和 AdjArray 的示例：

AdjList 可以用來表示社交網絡中的好友關係。
AdjArray 可以用來表示地圖中的道路連接。
總結

AdjList 和 AdjArray 各有優缺點，在選擇時需要根據具體的情況來決定。

 */