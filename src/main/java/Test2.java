/**
 * Created by YuChen on 2018/4/27 0027
 */
public class Test2 {

	public static class Node<T> {

		public T data;

		public Node(T data) { this.data = data; }

		public void setData(T data) {
			System.out.println("Node.setData");
			this.data = data;
		}
	}

	public static class MyNode extends Node<Integer> {
		public MyNode(Integer data) { super(data); }

		@Override
		public void setData(Integer data) {
			System.out.println("MyNode.setData");
			super.setData(data);
		}
	}

	public static void main(String[] args) {
//		MyNode mn = new MyNode(5);
//		Node n = mn;            // A raw type - compiler throws an unchecked warning
//		// equals: Node n = (MyNode)mn; after erasure
//		n.setData("Hello");
//		Integer x = mn.data;
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
