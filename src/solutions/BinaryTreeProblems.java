package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class BinaryTreeProblems {

	public static void preOrder( Node root ) {

		if( root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	
	public static int height(Node root) {
      	if(root == null){
              return -1;
          }
          int left = height(root.left);
          int right = height(root.right);
          if(left>right){
              return left + 1;
          }
            return right + 1;
          
    }

	public static Node insert(Node root,int data) {
		if (root==null) {
			return new Node(data);

		}
		if(data<root.data) {
			if(root.left==null) {
				root.left=new Node(data);
			}else {
				insert(root.left, data);
			}
		}else {
			if(root.right==null) {
				root.right=new Node(data);
			}else {
				insert(root.right, data);
			}
		}
		return root;


	}

	void decode(String s, Node root) {

		Node temp = root;
		for(char c : s.toCharArray()) {
			if(c=='1') {
				temp = temp.right;
			}else {
				temp = temp.left;
			}
			if(temp.right==null&&temp.left==null){
				System.out.print(temp.data);
				temp = root;
			}
		}
	}

	public static Node leastCommonAncestor(Node root, int v1, int v2) {
      	int larger;
        int smaller;
        if(v1>v2) {
            larger=v1;
            smaller=v2;
        }else {
            larger=v2;
            smaller=v1;
        }
       while((larger>root.data&&smaller>root.data)||(larger<root.data&&smaller<root.data)) {
            if(larger<root.data&&smaller<root.data) {
                root= root.left;
            }
            if(larger>root.data&&smaller>root.data) {
                root= root.right;
            }
        }
        return root;
    }


	public static void levelOrder(Node root) {

		List<Node> list = new ArrayList<Node>();

		list.add(root);

		while(!list.isEmpty()) {
			List<Node> current = new ArrayList<Node>();
			for(Node node : list) {
				System.out.print(node.data+" ");

				if(node.left!=null) {
					current.add(node.left);
				}
				if(node.right!=null) {
					current.add(node.right);
				}

			}

			list = current;
		}


	}

	public static void topView(Node root) {
		
		if(root==null) {
			return;
		}
		
		class NodeAndDistance{
			int distance;
			Node node;

			public NodeAndDistance(int distance, Node node) {
				super();
				this.distance = distance;
				this.node = node;
			}


		}
		
		Map<Integer,Node> map = new TreeMap<Integer, Node>();
		
		Queue<NodeAndDistance> queue = new LinkedList<NodeAndDistance>();

		queue.add(new NodeAndDistance(0, root));

		while(!queue.isEmpty()) {	

			NodeAndDistance currentNode = queue.poll();

			if(!map.containsKey(currentNode.distance)) {
				map.put(currentNode.distance, currentNode.node);
			}
			if(currentNode.node.left!=null) {
				queue.add(new NodeAndDistance(currentNode.distance-1, currentNode.node.left));

			}
			if(currentNode.node.right!=null) {
				queue.add(new NodeAndDistance(currentNode.distance+1, currentNode.node.right));
			}

		}

		for(int key : map.keySet()) {
			System.out.print(map.get(key).data+" ");
		}

	}	

	  boolean checkBST(Node root) {
          List<Node> tree = new ArrayList<>();
          addToList(root,tree);
          for(int i =1 ; i<tree.size();i++){
             if(tree.get(i).data<tree.get(i-1).data)return false;
          }
          return true;
      }
      
	  List<Node> addToList(Node root, List<Node> tree){
          if(root==null)return tree;
          addToList(root.left, tree);
          tree.add(root);
          addToList(root.right, tree);
          return tree;
      }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		int v1 = scan.nextInt();
		int v2 = scan.nextInt();
		scan.close();
		Node ans = leastCommonAncestor(root,v1,v2);
		System.out.println(ans.data);
	}	
}