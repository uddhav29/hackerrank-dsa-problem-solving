package solutions;

import java.util.concurrent.ThreadLocalRandom;

public class TotalStatesOfLife {

	public static void main(String[] args) throws InterruptedException {
		int[][] life = new int[10][10];

		for(int i = 0 ; i<life.length ;i++) { for(int j = 0; j<life.length;j++) {
			life[i][j]=ThreadLocalRandom.current().nextInt(0, 2);

		} }

		allStatesOfLife(life);
	}

	private static void allStatesOfLife(int[][] arr) throws InterruptedException {
		
		while(true) {

			for(int i = 0 ; i<arr.length ;i++) {

				for(int j = 0; j<arr.length;j++) {



					int aliveNeighbours = getNumberOfaliveNeighbours(arr, i, j);

					if(arr[i][j]==1) {

						if(aliveNeighbours<2) {
							arr[i][j]=0;

						}if(aliveNeighbours==2||aliveNeighbours==3) {

						}
						if(aliveNeighbours>3) {
							arr[i][j]=0;
						}

					}else if(aliveNeighbours==3){
						arr[i][j]=1;
					}

					System.out.print(arr[i][j]+" ");


				}
				System.out.println();
			}
			Thread.sleep(1000);
			System.out.println();
			System.out.println("new iteration");
			System.out.println();
		}

	}




	private static int getNumberOfaliveNeighbours(int[][] arr, int i, int j) {

		if(i-1<0&&j-1<0) {
			return arr[i][j+1]+
					arr[i+1][j]+arr[i+1][j+1];
		}

		if(i-1<0&&j-1>=0&&j+1<arr.length) {
			return arr[i][j+1]+arr[i][j-1]+
					arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
		}

		if(i-1<0&&j+1>arr.length-1) {
			return arr[i][j-1]+
					arr[i+1][j-1]+arr[i+1][j];
		}

		if(i-1>=0&&i+1<arr.length&&j-1<0) {
			return arr[i-1][j]+arr[i-1][j+1]
					+arr[i][j+1]+
					+arr[i+1][j]+arr[i+1][j+1];
		}

		if(i+1>arr.length-1&&j-1<0) {
			return arr[i-1][j]+arr[i-1][j+1]
					+arr[i][j+1];
		}

		if(i+1>arr.length-1&& j+1>0&&j+1<=arr.length-1) {
			return arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]
					+arr[i][j+1]+arr[i][j-1];
		}

		if(i+1>arr.length-1&& j+1>arr.length-1) {
			return arr[i-1][j-1]+arr[i-1][j]
					+arr[i][j-1];
		}

		if(i+1>0&& i+1<=arr.length-1 && j+1>arr.length-1) {
			return arr[i-1][j-1]+arr[i-1][j]
					+arr[i][j-1]+
					arr[i+1][j-1]+arr[i+1][j];
		}

		return arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1] +arr[i][j+1]+arr[i][j-1]+
				arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];

	}
}
