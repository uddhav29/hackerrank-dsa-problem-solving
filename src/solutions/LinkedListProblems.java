package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LinkedListProblems {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SinglyLinkedListNode other = (SinglyLinkedListNode) obj;
			if (data != other.data)
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
		}

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));
			System.out.println(node.data);
			node = node.next;

			if (node != null) {

				bufferedWriter.write(sep);
			}
		}
	}

	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

		SinglyLinkedListNode head = new SinglyLinkedListNode(data);

		if (llist == null) {
			return head;
		}
		head.next = llist;
		return head;
	}

	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

		SinglyLinkedListNode node = new SinglyLinkedListNode(data);

		if (position == 0) {
			node.next = head;
			return node;
		}

		SinglyLinkedListNode temp = head;

		while (position - 1 > 0) {
			temp = temp.next;
			position--;
		}

		node.next = temp.next;
		temp.next = node;

		return head;
	}

	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

		if (position == 0) {
			return head.next;
		}

		SinglyLinkedListNode temp = head;

		while (position - 1 > 0) {
			temp = temp.next;
			position--;
		}

		temp.next = temp.next.next;

		return head;

	}

	static void reversePrint(SinglyLinkedListNode head) {

		if (head.next == null) {
			System.out.println(head.data);
			return;
		}
		reversePrint(head.next);
		System.out.println(head.data);

	}

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

		SinglyLinkedListNode temp = head;

		while (temp.next != null) {
			
			while (temp.data == temp.next.data) {
				temp.next = temp.next.next;
				if(temp.next==null)break;
			}

			temp = temp.next;
			if(temp==null)break;
		}
		return head;
	}

	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {   
        
		Set<SinglyLinkedListNode> set = new LinkedHashSet<SinglyLinkedListNode>();
	
		while(head1!=null) {
			set.add(head1);
			head1=head1.next;
		}
        
		while(head2!=null) {
			if(set.contains(head2)) {
				return head2.data;
			}
			head2 = head2.next;
		}
		
        while(head1!=null) {
            
        	SinglyLinkedListNode temp = head2;
        	
        		while(temp!=null) {
        			if(head1==temp) {
        				return head1.data;
        			}
        			temp = temp.next;
        		}
            
        		head1 = head1.next;
        	}
        
        return 0;
        
    
}
	
	static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

		SinglyLinkedListNode current = head;
		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode next = null;

		if (head.next == null) {
			return head;
		}

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}

		return prev;

	}

	static SinglyLinkedListNode sort(SinglyLinkedListNode head) {

		if (head.next == null) {
			return head;
		}

		SinglyLinkedListNode current = head;
		List<Integer> list = new LinkedList<Integer>();

		while (current != null) {
			int data = (current.data * 10) + current.next.data;
			list.add(data);
			current = current.next.next;
		}
		Collections.sort(list);
		List<Integer> newlist = new LinkedList<Integer>();
		for (int i : list) {
			newlist.add(i / 10);
			newlist.add(i % 10);
		}
		SinglyLinkedListNode newHead = null;
		SinglyLinkedListNode temp = null;
		for (int i : newlist) {
			if (newHead == null) {
				newHead = new SinglyLinkedListNode(i);
				temp = newHead;
			} else {
				SinglyLinkedListNode node = new SinglyLinkedListNode(i);
				temp.next = node;
				temp = node;
			}

		}
		return newHead;
	}

	static boolean hasCycle(SinglyLinkedListNode head) {

		Set<SinglyLinkedListNode> set = new HashSet<SinglyLinkedListNode>();
		if (head == null) {
			return false;
		}
		SinglyLinkedListNode temp = head;
		while (temp != null) {
			if (set.contains(temp)) {
				return true;
			}
			set.add(temp);
			temp = temp.next;
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);

			llist.head = llist_head;
		}

		printSinglyLinkedList(removeDuplicates(llist.head), "\n", bufferedWriter);
		// printSinglyLinkedList(llist.head, "\n", bufferedWriter);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
