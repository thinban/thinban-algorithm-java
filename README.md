# thinban-algorithm-java

## 修复gitignore不生效的问题

git rm -r --cached . 一、数据结构相关#

## 数据结构
### 链表
1. 相交链表
2. 反转链表
3. 合并两个有序链表
4. 删除排序链表中的重复元素
5. 删除链表的倒数第 n 个节点
6. 两两交换链表中的节点
7. 两数相加 II
8. 回文链表
9. 分隔链表 
10. 10.奇偶链表

### 数组与矩阵
1. 移动零
2. 重塑矩阵
3. 最大连续1的个数
4. 搜索二维矩阵 II （1. 右上角开始遍历。 2.逐行遍历，二分法）
5. 有序矩阵中第 K 小的元素（基于priorityqueue实现小根堆计算）
6. 错误的集合(遍历数组，找到重复的数和丢失的数)
7. 寻找重复数
8. 优美的排列 II----2022年1月9日 （保持）
9. 数组的度
10. 托普利茨矩阵
11. 数组嵌套
12. 最多能完成排序的块

###栈和队列
1. 用栈实现队列
2. 用队列实现栈
3. 最小值栈
4. 用栈实现括号匹配
5. 数组中元素与下一个比它大的元素之间的距离
6. 循环数组中比当前元素大的下一个元素
## 二分法
```
//左闭右开型
public int search(int[] nums, int target) {
	int left = 0, right = nums.length;
	while (left < right) {
		int mid = left + ((right - left) >> 1);
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] < target)
			left = mid + 1;
		else if (nums[mid] > target)
			right = mid;
	}
	return -1;
}
```

## 双指针法（快慢指针法）
```
//通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
public int removeElement(int[] nums, int val) {
	// 快慢指针
	int fastIndex = 0;
	int slowIndex;
	for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
		if (nums[fastIndex] != val) {
			nums[slowIndex] = nums[fastIndex];
			slowIndex++;
		}
	}
	return slowIndex;

}

```

## 滑动窗口

```
//求子数组的题
int minSubArrayLen(int s, vector<int>& nums) {
	int result = INT32_MAX;
	int sum = 0; // 滑动窗口数值之和
	int i = 0; // 滑动窗口起始位置
	int subLength = 0; // 滑动窗口的长度
	for (int j = 0; j < nums.size(); j++) {
		sum += nums[j];
		// 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
		while (sum >= s) {
			subLength = (j - i + 1); // 取子序列的长度
			result = result < subLength ? result : subLength;
			sum -= nums[i++]; // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
		}
	}
	// 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
	return result == INT32_MAX ? 0 : result;
    }
```


-------------------------------------
处理有序数组，多考虑双指针(快慢、二分）