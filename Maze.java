import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.*;

class Maze {
	private int rows;
	private int cols;
	private char[][] maze;

	public Maze() {
		this.rows = 101;
		this.cols = 101;

		this.maze = new char[rows][cols];
	}

	public int getRows() {return this.rows;}
	public int getCols() {return this.cols;}
	public char[][] getMaze() {return this.maze;}

	public void generateMaze() {
		int start_row = (int)(Math.random() * this.rows);
		int start_col = (int)(Math.random() * this.cols);

		int goal_row = (int)(Math.random() * this.rows);
		int goal_col = (int)(Math.random() * this.cols);

		this.maze[start_row][start_col] = 'S';
		this.maze[goal_row][goal_col] = 'G';

		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.cols; j++) {
				if(i == start_row && j == start_col) {
					continue;
				}
				if(i == goal_row && j == goal_col) {
					continue;
				}

				if(Math.random() <= 0.3) {
					this.maze[i][j] = '1';
				} else {
					this.maze[i][j] = '0';
				}
			}
		}
	}

	public void writeMaze(int n) {
		try {
			String filename = "./Mazes/" + n + ".txt";
 			FileWriter writer = new FileWriter(filename, true);

			for(int i=0; i<this.rows; i++) {
    			for (int j=0; j<this.cols; j++) {
    				writer.write(this.maze[i][j]);
	    		}
    			writer.write("\n");
			}
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public char[][] readMaze(int n) {
		try {
			String filename = "./Mazes/" + n + ".txt";
			Scanner scanner = new Scanner(new File(filename));
			for(int i=0; i<this.rows; i++) {
				this.maze[i] = scanner.nextLine().toCharArray();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return this.maze;
	}

	public void printMaze() {
		for(int i=0; i<this.rows; i++) {
			System.out.println(Arrays.toString(this.maze[i]));
		}
	}

}