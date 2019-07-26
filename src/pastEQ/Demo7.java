package pastEQ;

public class Demo7 {

	public static void main(String[] args) {
//		Node node1 = new Node(3, new Node(7, new Node(6), new Node(4)), new Node(2, null, new Node(4)));
//		Node node2 = new Node(5, new Node(2, null, new Node(4)), new Node(6));
//		System.out.println(node1.getMax(node1));
//		System.out.println(node2.getMax(node2));
		int[] seq1 = { 3, 5, 7, 6, 2, 4 };
		//int[] seq2 = { 3, 5, 7, 2, 6, 4 };

		Node node1 = new Node(0, new Node(seq1[0]), new Node(seq1[1]));
		//TODO 构建一棵树
		System.out.println(node1.getMax(node1));

	}

	static class Node {
		int value = 0;
		private Node left;
		private Node right;

		public Node(int value) {
			super();
			this.value = value;
		}

		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public int getMax(Node root) {
			int sum = 0;
			if (null != root) {
				sum += root.value;
				int temp1 = getMax(root.getLeft());
				int temp2 = getMax(root.getRight());
				sum += temp1 > temp2 ? temp1 : temp2;
			}
			return sum;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

}
