package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class StableForestProblem
{

	static int balancedForest(int[] c, int[][] edges) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int result = Integer.MAX_VALUE;

		for(int i = 0; i < edges.length;i++) {

			if(map.containsKey(edges[i][0])) {
				map.get(edges[i][0]).add(edges[i][1]);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(edges[i][1]);
				map.put(edges[i][0], list);
			}
			if(map.containsKey(edges[i][1])) {
				map.get(edges[i][1]).add(edges[i][0]);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(edges[i][0]);
				map.put(edges[i][1], list);
			}
		}


		for(int i = 0; i < edges.length - 1;i++) {

			for(int j = i+1; j < edges.length;j++) {
				
				boolean[] visited = new boolean[c.length+1];
				
				visited[1] = true;
				
				int[] sum = new int[3];
				int first, second;
				if(edges[i][1]>edges[i][0]) {
					first = edges[i][1]; 
					visited[first] = true;
				}else {
					first = edges[i][0];
					visited[first] = true;
				}
				
				if(edges[j][1]>edges[j][0]) {
					second = edges[j][1];
					visited[second] = true;
				}else {
					second = edges[j][0];
					visited[second] = true;
				}
				
				sum[0] = getSum(1, visited, map, c);
				sum[1] = getSum(first, visited, map, c);
				sum[2] = getSum(second, visited, map, c);
				Arrays.sort(sum);
				
				if((sum[1]==sum[2])&&(sum[0]<=sum[1])) {
					int temp = sum[1] - sum[0];
					if(result>temp) {
						result = temp;
					}
				}
			}
		}
		
		if(result == Integer.MAX_VALUE) {
            for(int i = 0; i < edges.length;i++) {
                boolean[] visited = new boolean[c.length+1];
                visited[1] = true;
                visited[edges[i][1]] = true;
                int sumFirstCut = getSum(edges[i][1], visited, map, c);
                int remainingSum = getSum(1, visited, map, c);
                if(sumFirstCut == remainingSum) {
                    return sumFirstCut;
                }
            }
            return -1;
        }
		
		return result;

	}
	
	static int getSum(int root, boolean[] visited, Map<Integer, List<Integer>> map, int[] value) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		 while(!queue.isEmpty()) {
			 int node = queue.poll();
			 result = result + value[node-1];
			 if(map.containsKey(node)) {
			 for(int adj : map.get(node)) {
				 if(!visited[adj]) {
					 visited[adj] = true;
					 queue.add(adj);
				 }
			 }
		 }
		 } 
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] c = new int[n];

			String[] cItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int cItem = Integer.parseInt(cItems[i]);
				c[i] = cItem;
			}

			int[][] edges = new int[n - 1][2];

			for (int i = 0; i < n - 1; i++) {
				String[] edgesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++) {
					int edgesItem = Integer.parseInt(edgesRowItems[j]);
					edges[i][j] = edgesItem;
				}
			}

			int result = balancedForest(c, edges);
			System.out.println(result);
			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
