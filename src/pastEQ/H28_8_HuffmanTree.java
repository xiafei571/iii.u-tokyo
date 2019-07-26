package pastEQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * H28-8 哈夫曼树
 * 
 * @author xiafei
 *
 */
public class H28_8_HuffmanTree {

	private static String[] telegram1 = { "c", "a", "d", "a", "b", "b", "a", "a", "c", "a", "b", "a", "a", "a", "c",
			"d", "a", "a", "a", "b" };

	public static void main(String[] args) {
		List<Node> nodeList = getProbability(telegram1);

		sortList(nodeList);

		buildHuffmanTree(nodeList);

		for (int i = nodeList.size() - 1; i >= 0; i--) {
			if (null != nodeList.get(i).getLeft()) {
				nodeList.get(i).getLeft().setCode(nodeList.get(i).getCode() + "0");
			}
			if (null != nodeList.get(i).getRight()) {
				nodeList.get(i).getRight().setCode(nodeList.get(i).getCode() + "1");
			}
		}

		for (Node node : nodeList) {
			if (null != node.getName())
				System.out.println(node);
		}
	}

	private static void buildHuffmanTree(List<Node> nodeList) {
		List<Node> temp = new ArrayList<Node>();

		Iterator<Node> iterator = nodeList.iterator();
		while (iterator.hasNext()) {
			Node node = iterator.next();
			if (null == node.getFather()) {
				temp.add(node);
				iterator.remove();
				if (temp.size() == 2)
					break;
			}
		}

		if (temp.size() == 0) {
			return;
		} else if (temp.size() == 1) {
			nodeList.add(temp.get(0));
			return;
		} else if (temp.size() == 2) {
			Node left = temp.get(0);
			Node right = temp.get(1);
			Node newNode = new Node(null, left, right, left.getValue() + right.getValue(), null);
			left.setFather(newNode);
			right.setFather(newNode);
			nodeList.add(left);
			nodeList.add(right);
			nodeList.add(newNode);
			sortList(nodeList);
			// 递归
			buildHuffmanTree(nodeList);
		}
	}

	private static List<Node> getProbability(String[] telegram) {

		List<Node> nodeList = new ArrayList<Node>();

		for (String s : telegram) {

			if (nodeList.isEmpty()) {
				nodeList.add(new Node(1, s));
			} else {
				boolean find = false;
				for (int i = 0; i < nodeList.size(); i++) {
					if (s.equals(nodeList.get(i).getName())) {
						find = true;
						nodeList.get(i).increase();
					}
				}
				if (!find)
					nodeList.add(new Node(1, s));
			}

		}

		return nodeList;
	}

	private static void sortList(List<Node> list) {
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.getValue() > o2.getValue()) {
					return 1;
				} else if (o1.getValue() < o2.getValue()) {
					return -1;
				} else {
					return 0;
				}
			}

		});
	}

	static class Node {
		private Node father;

		private Node left;

		private Node right;

		private int value;

		private String name;

		private String code = "";

		public Node getFather() {
			return father;
		}

		public void setFather(Node father) {
			this.father = father;
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

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Node(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public Node(Node father, Node left, Node right, int value, String name) {
			super();
			this.father = father;
			this.left = left;
			this.right = right;
			this.value = value;
			this.name = name;
		}

		public Node() {
		}

		@Override
		public String toString() {
			return "value=" + value + ", name=" + name + ", code=" + code;
		}

		public void increase() {
			this.value++;
		}

	}
}
