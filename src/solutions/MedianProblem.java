package solutions;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianProblem {
	//TODO: Incomplete solution
	public static void median(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> heap = new PriorityQueue();

		int input = Integer.parseInt(sc.nextLine());

		while(input>0){

			String[] query = sc.nextLine().split(" ");

			if(query[0].equals("a")){
				heap.add(Integer.parseInt(query[1]));
				if(heap.size()%2==0){
					//float median = heap.
				}
			}
			if(query[0].equals("r")){
				if(heap.contains(Integer.parseInt(query[1]))) {
					heap.remove(Integer.parseInt(query[1]));
				}else {
					System.out.println("wrong!");
				}
			}
			input--;
		}
	}

}
