import javax.swing.JFrame;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// StarterFrame frame = new StarterFrame();
		// frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.pack();
		// frame.setLocationRelativeTo(null);

		Maze maze = new Maze();
		maze.generateMaze();
		maze.writeMaze(1);
		System.out.println("Original maze");
		maze.printMaze();


		Maze maze2 = new Maze();
		char[][] char_maze = maze2.readMaze(1);
		System.out.println("New maze");
		maze2.printMaze();

		System.out.println("New char maze");
		for(int i=0; i<maze2.getRows(); i++) {
			System.out.println(Arrays.toString(char_maze[i]));
		}


	}

}
