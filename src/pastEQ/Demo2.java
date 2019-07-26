package pastEQ;

import org.apache.commons.lang3.StringUtils;

public class Demo2 {

	public static void main(String[] args) {
		// 给定一个数组，将数组向右移动k步，其中k为非负数。
		/*
		 * Example 样例 1: 输入: [1,2,3,4,5,6,7], k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转1步:
		 * [7,1,2,3,4,5,6] 向右旋转2步: [6,7,1,2,3,4,5] 向右旋转3步: [5,6,7,1,2,3,4] 样例 2: 输入:
		 * [-1,-100,3,99], k = 2 输出: [3,99,-1,-100] 解释: 向右旋转1步: [99,-1,-100,3] 向右旋转2步:
		 * [3,99,-1,-100]
		 */
		rotateArray(3);
		System.out.println();
		/*
		 * 给定一个整数数组，其中1 ≤ a[i] ≤ n (n =数组的大小)，一些元素出现两次，其他元素出现一次。 找到 [1,n]
		 * 中所有没有出现在此数组中的元素。 你可以在没有额外空间和O(n)运行时的情况下完成吗？ 您可以认为返回的列表不计为额外空间。 Example 输入:
		 * [4,3,2,7,8,2,3,1] 输出: [5,6]
		 */
		findAllNumbersDisappearedInAnArray();

		errorDemo(null, " ");
	}

	/**
	 * 找到不包含的数字
	 */
	private static void findAllNumbersDisappearedInAnArray() {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		// i: 0, 1, 2, 3, 4, 5, 6, 7
		// nums[i]: -4, -3, -2, -7, 8, 2, -3, -1
		// 5 6

		// 打印 i = 5
		// n = nums.length = 8, 意味着需要有1-8
		// TODO 输出5，6

		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i]) - 1] >= 0) {
				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
			}
		}

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] > 0) {
				System.out.println(j + 1);
			}
		}

	}

	private static void rotateArray(int k) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		// 3 -> [5,6,7,1,2,3,4]
		// nums [1, 2, 3, 4, 5, 6, 7]
		// arry [5, 2, 7, 1, 2, 3, 4]
		int[] arry = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arry[(i + k) % nums.length] = nums[i];
			// System.out.println("arry数组的第"+((i + k) % nums.length)+"位"+"设置为了"+nums[i]);
		}

		for (int i : arry) {
			System.out.print(i);
		}
	}

	private static void errorDemo(Integer age, String name) {
		if (null == age)
			age = 0;
		System.out.println(null == name || "".equals(name));
		System.out.println(StringUtils.isEmpty(name));
		System.out.println(StringUtils.isBlank(name));
		String a = "NBCBABC";
		String b = "A";

		System.out.println(a + b);

		StringBuilder sb = new StringBuilder("NB");
		sb.append("A").append("/").append("CBA");
		System.out.println(sb.toString());

		// System.out.println(a.charAt(1));
		System.out.println(a.indexOf("C"));

		String weburl = "baidu.www.com";
		System.out.println(weburl.startsWith("www"));

		Integer i = 212;
		Integer j = 212;
		System.out.println(i.equals(j));
		System.out.println(i.compareTo(j));
		System.out.println(i.intValue() == j.intValue());

	}
}
