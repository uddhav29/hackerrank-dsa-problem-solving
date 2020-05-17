package solutions;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CastleOnGridProblem {

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    	int n = grid.length;
    	boolean[][] visited = new boolean[n][n]; 
    	int[][] minLength = new int[n][n];
    	Queue<Integer[]> queue = new LinkedList<Integer[]>();
    	for(int i = 0; i<n;i++) {
    		for(int j = 0; j<n; j++) {
    			if(grid[i].charAt(j)=='X') {
    				visited[i][j] = true;
    				minLength[i][j] = -1;
    			}else minLength[i][j] = 100;
    		}   
    	}
    	minLength[startX][startY] = 0;
    	queue.add(new Integer[]{startX,startY});
    	visited[startX][startY] = true;
    	
    	while(!queue.isEmpty()) {
    		
    		Integer[] current = queue.poll();   
    		int currentValue = minLength[current[0]][current[1]];
    		
    		for(int i = current[0]; i<n && minLength[i][current[1]] != -1 ; i++ ) {
    			if(!visited[i][current[1]]) {
    				visited[i][current[1]] = true;
    				if(currentValue+1<minLength[i][current[1]]) {
    					minLength[i][current[1]] = currentValue+1;
    				}
    				queue.add(new Integer[]{i,current[1]});
    			}
    		}
    		for(int i = current[0]; i>=0 && minLength[i][current[1]] != -1 ; i-- ) {
    			if(!visited[i][current[1]]) {
    				visited[i][current[1]] = true;
    				if(currentValue+1<minLength[i][current[1]]) {
    					minLength[i][current[1]] = currentValue+1;
    				}
    				queue.add(new Integer[]{i,current[1]});
    			}
    		}
    		for(int i = current[1]; i>=0 && minLength[current[0]][i] != -1; i-- ) {
    			if(!visited[current[0]][i]) {
    				visited[current[0]][i] = true;
    				if(currentValue+1<minLength[current[0]][i]) {
    					minLength[current[0]][i] = currentValue+1;
    				}
    				queue.add(new Integer[]{current[0],i});
    			}
    		}		
    		for(int i = current[1]; i<n && minLength[current[0]][i] != -1; i++ ) {
    			if(!visited[current[0]][i]) {
    				visited[current[0]][i] = true;
    				if(currentValue+1 < minLength[current[0]][i]) {
    					minLength[current[0]][i] = currentValue+1;
    				}
    				queue.add(new Integer[]{current[0],i});
    			}
    		}
    	}
    	
    	return minLength[goalX][goalY];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
