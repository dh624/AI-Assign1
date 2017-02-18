import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	private JLabel leftlabel = new JLabel("Current State Info");
	private JLabel rightlabel = new JLabel("Next State Info");
	private JLabel northlabel = new JLabel();
	private JTextArea leftArea = new JTextArea(25,25);
	private JTextArea rightArea = new JTextArea(25,25);
	private JButton next = new JButton("Next iteration");
	private JPanel[][] gridpanel;
	private JLabel[][] gridlabel;
	private JPanel center = new JPanel();
	private JPanel leftpanel = new JPanel();
	private JPanel rightpanel = new JPanel();
	private JPanel bottompanel = new JPanel();
	public State start;
	public State goal;
	
	
	
	public MyFrame(int rows, int cols, String algorithm){
	this.setTitle("Demonstration of " + rows + "x" + cols + " " + algorithm + " Search");
	this.setLayout(new BorderLayout(10,10));
	center.setLayout(new GridLayout(rows,cols));
	gridpanel = new JPanel[rows][cols];
	gridlabel = new JLabel[rows][cols];
	for(int i = 0; i< rows; i++){
		for(int j = 0; j < cols; j++){
			gridpanel[i][j] = new JPanel();
			gridpanel[i][j].setOpaque(true);
			gridpanel[i][j].setBackground(Color.GRAY);
			gridlabel[i][j] = new JLabel("A");
			gridlabel[i][j].setForeground(Color.red);
			gridpanel[i][j].add(gridlabel[i][j]);
			center.add(gridpanel[i][j]);
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
	
	
	this.add(northlabel, BorderLayout.NORTH);
	this.add(bottompanel, BorderLayout.SOUTH);
	this.add(leftpanel, BorderLayout.WEST);
	this.add(rightpanel, BorderLayout.EAST);
	this.add(center, BorderLayout.CENTER);

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
