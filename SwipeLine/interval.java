public class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，说明不重叠。
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之说明重叠，则将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}

// https://mp.weixin.qq.com/s/ioUlNa4ZToCrun3qb4y4Ow

// 合併n個區間
class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}


// 插入區間
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        // 遍历区间列表：
        // 首先将新区间左边且相离的区间加入结果集
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
        // 将最终合并后的新区间加入结果集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        // 最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length) {
            res[idx++] = intervals[i++];
        }

        return Arrays.copyOf(res, idx);
    }
}


// I/III都是付費題
// https://www.lintcode.com/problem/919/description

// 會議室
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // 将区间按照会议开始实现升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历会议，如果下一个会议在前一个会议结束之前就开始了，返回 false。
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}

// 會議室II
// https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/253.%20Meeting%20Rooms%20II.md

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 按照会议的开始时间进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 创建一个最小堆（优先队列）
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && minHeap.peek() <= interval[0]) {
                // 如果有空闲的会议室，将当前会议安排在最早结束的会议室
                pq.poll();
            }
            // 将当前会议的结束时间加入堆中
            pq.offer(interval[1]);
        }
        
        // 堆中的元素个数即为所需的会议室数量
        return pq.size();
    }
}
// LintCode上面和Leetcode不一樣，前者List，後者Array

// Compater寫法可以問ChatGpt
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        pq.offer(intervals.get(0).end);
        
        for (int i = 1; i < intervals.size(); i++) {
            if (pq.peek() < intervals.get(i).start) {
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
        }
        return pq.size();    
    }
}

// 會議室III
// https://leetcode.cn/problems/meeting-rooms-iii/solutions/1799420/shuang-dui-mo-ni-pythonjavacgo-by-endles-ctwc/