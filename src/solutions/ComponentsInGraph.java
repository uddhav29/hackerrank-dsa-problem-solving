package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ComponentsInGraph {

    static int[] componentsInGraph(int[][] gb) {
    	
    	int max = Integer.MIN_VALUE;
    	
    	int maxBool = Integer.MIN_VALUE;
    	
    	int min = Integer.MAX_VALUE;
    	
    	
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	
    	for(int i = 0; i<gb.length; i++) {
    		
    		if(map.containsKey(gb[i][0])) {
    			map.get(gb[i][0]).add(gb[i][1]);
    			
    		}else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(gb[i][1]);
    			map.put(gb[i][0], list);
    		}
    		
    		if(map.containsKey(gb[i][1])) {
    			map.get(gb[i][1]).add(gb[i][0]);
    			
    		}else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(gb[i][0]);
    			map.put(gb[i][1], list);
    		}
    		
    		if(gb[i][0]>maxBool) {
    			maxBool= gb[i][0];
    		}
    		
    		if(gb[i][1]>maxBool) {
    			maxBool= gb[i][1];
    		}
    	}
    	
    	boolean[] visit = new boolean[maxBool+1];
    	
    	for(int i : map.keySet()) {
	
    		Queue<Integer> queue = new LinkedList<Integer>();
    		
    		queue.add(i);
    		visit[i] = true;
    		int count = 1;
    		while(!queue.isEmpty()) {
    			int node = queue.poll();
    			for(int j : map.get(node)) {
    				if(!visit[j]) {
    	    			visit[j]=true;
    	    			queue.add(j);
    	    			count++;
    	    		}
    			}
    		}
    		if(count>max) {
    			max = count;
    		}
    		
    		if(count < min && count != 1) {
    			min = count;
    		}
    	
    	}
    	
    	int[] result = new int[2];
    	result[0] = min;
    	result[1] = max; 
    	return result;
      

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
           
        	System.out.println(result[SPACEItr]);
        	bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
