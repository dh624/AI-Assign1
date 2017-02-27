import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	public JLabel leftlabel = new JLabel("Current State Info");
	public JLabel rightlabel = new JLabel("Goal State Info");
	public JLabel northlabel = new JLabel();
	public static JTextArea leftArea = new JTextArea(25,25);
	public static JTextArea rightArea = new JTextArea(25,25);
	public JButton next = new JButton("Next iteration");
	public JButton complete = new JButton("Full Algorithm");
	public static JPanel[][] gridpanel;
	public static JLabel[][] gridlabel;
	public JPanel center = new JPanel();
	public JPanel leftpanel = new JPanel();
	public JPanel rightpanel = new JPanel();
	public JPanel bottompanel = new JPanel();
	public static State start;
	public static State goal;
	public static String algorithm;
	public static BFSTree tree;
	public static Heap heap;
	public static int count; //cells expanded
	public static int moves; //iterations
	public static int pathlength;
	public static int adaptiveH;
	
	public MyFrame(int rows, int cols,int mazes, String algorithm){
	this.setTitle("Demonstration of " + rows + "x" + cols + " " + algorithm + " Search");
	this.setLayout(new BorderLayout(10,10));
	this.algorithm = algorithm;
	center.setLayout(new GridLayout(rows,cols));
	gridpanel = new JPanel[rows][cols];
	gridlabel = new JLabel[rows][cols];
	Maze maze = new Maze();
	char[][] temp = maze.readMaze(mazes);
	for(int i = 0; i< rows; i++){
		for(int j = 0; j < cols; j++){
			gridpanel[i][j] = new JPanel();
			gridpanel[i][j].setOpaque(true);
			if(temp[i][j] == '1'){
				gridpanel[i][j].setBackground(Color.BLACK);
				gridlabel[i][j] = new JLabel("");
				gridpanel[i][j].add(gridlabel[i][j]);
				center.add(gridpanel[i][j]);
				continue;
			}else
			if(temp[i][j] == 'S'){
				start = new  State(i,j,null);
				gridlabel[i][j] = new JLabel("S");
				gridpanel[i][j].setBackground(Color.RED);
				center.add(gridpanel[i][j]);
				continue;
			}else
			if(temp[i][j] == 'G'){//case g
				goal = new State(i,j,null);
				gridlabel[i][j] = new JLabel("T");
				gridpanel[i][j].setBackground(Color.GREEN);
				gridpanel[i][j].add(gridlabel[i][j]);
				center.add(gridpanel[i][j]);
				continue;
			}else{
				gridlabel[i][j] = new JLabel("");
				gridpanel[i][j].setBackground(Color.WHITE);
				gridpanel[i][j].add(gridlabel[i][j]);
				center.add(gridpanel[i][j]);
			}
		}
	}
	leftpanel.setLayout(new BorderLayout(10,10));
		leftpanel.add(leftlabel, BorderLayout.NORTH);
		leftpanel.add(leftArea, BorderLayout.CENTER);		
	
	rightpanel.setLayout(new BorderLayout(10,10));
		rightpanel.add(rightlabel, BorderLayout.NORTH);
		rightpanel.add(rightArea, BorderLayout.CENTER);	
	
	bottompanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		bottompanel.add(next);
		bottompanel.add(complete);
	
	
	this.add(northlabel, BorderLayout.NORTH);
	this.add(bottompanel, BorderLayout.SOUTH);
	this.add(leftpanel, BorderLayout.WEST);
	this.add(rightpanel, BorderLayout.EAST);
	this.add(center, BorderLayout.CENTER);
	this.next.addActionListener(this);
	this.complete.addActionListener(this);
	count = 0;
	moves = 0;
	pathlength =0;
	adaptiveH = 0;
	heap = new Heap();
	tree = new BFSTree();
	if(algorithm.equals("Backward A*")){
		System.out.println("backward case\n");
		State tempState = start;
		start = goal;
		goal = tempState;
	}
	tree.head = start;
	goal.f_s = Math.abs((goal.x - start.x)) +Math.abs((goal.y - start.y));
	tree.current = start;
	leftArea.setText("Position  "+ start.x + " " + start.y + "\n"
					+ "g_n ="+ start.g_s + "\n"
					+ "h_n ="+ start.h_s + "\n"
					+ "f_n ="+ start.f_s );
	rightArea.setText("Position  "+ goal.x + " " + goal.y + "\n"
			+ "g_n ="+ goal.g_s + "\n"
			+ "h_n ="+ goal.h_s + "\n"
			+ "f_n ="+ goal.f_s );

}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isDone = false;
		if(e.getActionCommand().equals("Full Algorithm")){
			while(!isDone){
					moves++;
					tree.explorebottom();
					tree.exploreleft();
					tree.exploreright();
					tree.exporetop();
					tree.updateCurrent();
					if(tree.current == null){
						JOptionPane.showMessageDialog(this, "No Solution");
						isDone = true;
						return;
					}
					if(tree.current.x == goal.x && tree.current.y== goal.y){
						State temp = tree.current;
						while(temp.parentState != null){
							pathlength++;
							gridpanel[temp.x][temp.y].setBackground(Color.PINK);
							temp = temp.parentState;
						}
						JOptionPane.showMessageDialog(this, "Path Found \nExpanded Cells: " + count + "\n" + "Number of Moves: " + moves + "\n"+ "Path Length: " + pathlength );
						isDone = true;
						return;
					}
					if(next == null){
						JOptionPane.showMessageDialog(this, "No Solution");
						isDone = true;
						return;
					}
					
			}
		}
		tree.explorebottom();
		tree.exploreleft();
		tree.exploreright();
		tree.exporetop();
		tree.updateCurrent();
		State next = heap.peek();
		if(tree.current == null){
			JOptionPane.showMessageDialog(this, "No Solution");
		}
		if(tree.current.x == goal.x && tree.current.y== goal.y){
			JOptionPane.showMessageDialog(this, "Path Found \n Expanded Cells: " + count);
			State temp = tree.current;
			while(temp.parentState != null){
				gridpanel[temp.x][temp.y].setBackground(Color.PINK);
				temp = temp.parentState;
			}
		}
		if(next == null){
			JOptionPane.showMessageDialog(this, "No Solution");
		}
		leftArea.setText("Position  "+ tree.current.x + " " + tree.current.y + "\n"
				+ "g_n ="+ tree.current.g_s + "\n"
				+ "h_n ="+ tree.current.h_s + "\n"
				+ "f_n ="+ tree.current.f_s );
		
		
	}
}
