// afrid's code

public class rat {

	
	static int N;

	void printSolution(int sol[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(
					" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	
	boolean isSafe(
		int maze[][], int x, int y,int sol[][])
	{
		return (x >= 0 && x < N && y >= 0
				&& y < N && maze[x][y] == 1 && sol[x][y]==0);
      
	}

	
	boolean solveMaze(int maze[][])
	{
		int sol[][] = new int[N][N];
		sol[0][0]=1;
		solveMazeUtil(maze, 0, 0, sol);

		printSolution(sol);
		return true;
	}

	
  int[] x_d={-1,0,0,1};
  int[] y_d={0,-1,1,0};
	boolean solveMazeUtil(int maze[][], int x, int y,
						int sol[][])
	{
		if (x == N - 1 && y == N - 1
			&& maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

      for(int i=0;i<x_d.length;i++)
      { int new_x = x+ x_d[i];
       int new_y = y+ y_d[i];
		if (isSafe(maze, new_x, new_y,sol) == true) {
			
			sol[new_x][new_y] = 1;
     
			if (solveMazeUtil(maze,new_x, new_y, sol))
				return true;

			

			sol[new_x][new_y] = 0;
			
		}
      }

		return false;
	}

	public static void main(String args[])
	{
		rat r = new rat();
		int maze[][] = { { 1, 0, 0, 0 },
						{ 1, 1, 0, 1 },
						{ 0, 1, 0, 0 },
						{ 1, 1, 1, 1 } };

		N = maze.length;
		r.solveMaze(maze);
	}
}

