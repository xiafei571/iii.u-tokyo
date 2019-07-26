package pastEQ;

import java.util.Stack;

/**
 * RPN(Reverse Polish notation) Demo
 * 
 * @author xiafei
 *
 */
public class Demo4 {
	private static final char PLUS = '+';
	private static final char REDU = '-';
	private static final char MULI = '*';

	private static int rpn(String equ) {
		if (null == equ || "".equals(equ))
			return 0;

		//定义一个栈
		Stack<Integer> s = new Stack<Integer>();
		int sum = 0;

		char[] charArray = equ.toCharArray();
		for (char c : charArray) {
			if (isNum(c)) {// 如果是数字，入栈
//				System.out.println(c + "入栈");
				s.push(Character.getNumericValue(c));
			} else {// 如果不是数字是操作符
				switch (c) {
				case PLUS:
					sum = s.pop() + s.pop();
					s.push(sum);
//					System.out.println(c + "操作符，" + sum + "入栈");
					break;
				case REDU:
					sum = s.pop() - s.pop();
					s.push(sum);
//					System.out.println(c + "操作符，" + sum + "入栈");
					break;
				case MULI:
					sum = s.pop() * s.pop();
					s.push(sum);
//					System.out.println(c + "操作符，" + sum + "入栈");
					break;
				default:
					break;
				}
			}
		}
		return (int) s.pop();
	}

	public static void main(String[] args) {
		System.out.println(rpn("13+4*"));
		System.out.println(rpn("23*46+*"));
	}

	private static boolean isNum(char c) {
		if (c < 48 || c > 57)
			return false;
		return true;
	}
}
