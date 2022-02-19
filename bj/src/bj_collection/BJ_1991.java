package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_1991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static Node[] Tree;
	
	static class Node{
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public void addLeft(Node node) {
			this.left = node;
		}
		
		public void addRight(Node node) {
			this.right = node;
		}
	}
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		Tree = new Node[N];
		int a = 65;
		for(int i=0; i<N; i++) {
			Tree[i] = new Node((char)a);
			a++;
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int data = (int)st.nextToken().charAt(0)-65;
			int left = (int)st.nextToken().charAt(0)-65;
			int right = (int)st.nextToken().charAt(0)-65;
			
			if(left>=0)
				Tree[data].addLeft(Tree[left]);
			if(right>=0)
				Tree[data].addRight(Tree[right]);
		}
		preOrder(Tree[0]);
		bw.write("\n");
		inOrder(Tree[0]);
		bw.write("\n");
		postOrder(Tree[0]);
		bw.flush();
		bw.close();
	}
	
	public static void preOrder(Node node) throws IOException{
		if(node==null) return;
		
		bw.write(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) throws IOException{
		if(node==null) return;
		
		inOrder(node.left);
		bw.write(node.data);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) throws IOException{
		if(node==null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		bw.write(node.data);
	}
}
