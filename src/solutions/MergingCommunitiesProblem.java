package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MergingCommunitiesProblem {

	public static void main(String[] args) {
		optimal();
		//naive();
	}

	public static void optimal() {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int queries = Integer.parseInt(input[1]);
		Map<Integer, Integer> rootMap = new HashMap<>();
		Map<Integer, Set<Integer>> communityMap = new HashMap<>();
		while(queries>0) {
			String[] query = sc.nextLine().split(" ");
			if(query[0].equals("M")) {

				int firstNode = Integer.parseInt(query[1]);
				int secondNode = Integer.parseInt(query[2]);

				if((rootMap.containsKey(firstNode) && rootMap.containsKey(secondNode))) {

					Integer firstNodeRoot = rootMap.get(firstNode);
					Integer secondNodeRoot = rootMap.get(secondNode);

					if(!firstNodeRoot.equals(secondNodeRoot)) {
						//merge both list with root of each elements as root of smaller list
						if(communityMap.get(firstNodeRoot).size()>communityMap.get(secondNodeRoot).size()) {
							Set<Integer> current = communityMap.get(secondNodeRoot);
							communityMap.get(firstNodeRoot).addAll(current);
							for(int i : current) {
								rootMap.put(i, firstNodeRoot);
							}
						}else {
							Set<Integer> current = communityMap.get(firstNodeRoot);
							communityMap.get(secondNodeRoot).addAll(current);
							for(int i : current) {
								rootMap.put(i, secondNodeRoot);
							}
						}
					}
				}else if(rootMap.containsKey(firstNode)) {
					Integer firstNodeRoot = rootMap.get(firstNode);
					rootMap.put(secondNode,firstNodeRoot);	
					communityMap.get(firstNodeRoot).add(secondNode);
				}else if(rootMap.containsKey(secondNode)) {
					Integer secondNodeRoot = rootMap.get(secondNode);
					rootMap.put(firstNode,secondNodeRoot);
					communityMap.get(secondNodeRoot).add(firstNode);
				}else {
					rootMap.put(firstNode,firstNode);
					rootMap.put(secondNode,firstNode);
					Set<Integer> list = new HashSet<Integer>();
					list.add(firstNode);
					list.add(secondNode);
					communityMap.put(firstNode,list);
				}


			}
			if(query[0].equals("Q")) {
				if(rootMap.containsKey(Integer.parseInt(query[1]))) {		
					System.out.println(communityMap.get(rootMap.get(Integer.parseInt(query[1]))).size());
				}else System.out.println("1");
			}

			queries--;
		}



	}




	public static void naive() {

		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int queries = Integer.parseInt(input[1]);
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		while(queries>0) {
			String[] query = sc.nextLine().split(" ");
			if(query[0].equals("M")) {
				int firstNode = Integer.parseInt(query[1]);
				int secondNode = Integer.parseInt(query[2]);

				if(map.containsKey(firstNode)) {
					map.get(firstNode).add(secondNode);    
				}else {
					List<Integer> list = new LinkedList<Integer>();
					list.add(secondNode);
					map.put(firstNode, list);
				}

				if(map.containsKey(secondNode)) {
					map.get(secondNode).add(firstNode);    
				}else {
					List<Integer> list = new LinkedList<Integer>();
					list.add(firstNode);
					map.put(secondNode, list);
				}

			}
			if(query[0].equals("Q")) {

				System.out.println(getCommunitySize(Integer.parseInt(query[1]),map, Integer.parseInt(input[0])));

			}

			queries--;
		}


	}


	private static int getCommunitySize(int root, Map<Integer, List<Integer>> map, int nodes) {
		boolean[] visited = new boolean[nodes+1];
		visited[root] = true;
		int result = 1; 
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		if(map.containsKey(root)) {
			while(!queue.isEmpty()) {
				for(int adj : map.get(queue.poll())) {
					if(!visited[adj]) {
						visited[adj] = true;
						queue.add(adj);
						result++;
					}
				}
			}
		}
		return result;
	}
}