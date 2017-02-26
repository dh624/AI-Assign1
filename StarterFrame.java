import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionListener;

public class StarterFrame extends JFrame implements ActionListener {
	private String[] options = {"Repeated A*", "Backward A*", "Adaptive A*"};
	private JLabel rows = new JLabel("Enter the number of rows");
	private JLabel cols = new JLabel("Enter the number of columns");
	private JLabel mazes = new JLabel("Enter the maze number to load");
	private JTextField numofRows = new JTextField(2);
	private JTextField numofCols = new JTextField(2);
	private JTextField mazeno = new JTextField(2);
	private JPanel center = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel north = new JPanel();
	private JLabel algo = new JLabel("Select Algorithm");
	private JComboBox<String> boxoptions= new JComboBox<String>(options);
	private JButton start = new JButton("Continue");
	
	public StarterFrame(){
		this.setTitle("Initialize Grid Size");
		this.setLayout(new BorderLayout(10,10));
		center.setLayout(new GridLayout(3,3));
			center.add(rows);
			center.add(numofRows);
			center.add(cols);
			center.add(numofCols);
			center.add(mazes);
			center.add(mazeno);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			bottom.add(start);
		north.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			north.add(algo);
			north.add(boxoptions);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);	
		this.add(north, BorderLayout.NORTH);
		start.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(numofRows.getText().equals("") && numofCols.getText().equals("") && mazeno.getText().equals("")){
			JOptionPane.showMessageDialog(this, "The number of rows, columns, and maze number are missing");
			return;
		}
		if(numofRows.getText().equals("")){
			JOptionPane.showMessageDialog(this, "The number of rows is missing");
			return;
		}
		if(numofCols.getText().equals("")){
			JOptionPane.showMessageDialog(this, "The number of columns is missing");
			return;
		}
		if(mazeno.getText().equals("")){
			JOptionPane.showMessageDialog(this, "The maze number is missing");
			return;
		}
		try{
	        Integer.parseInt(mazeno.getText());
	    }catch(NumberFormatException e){
	        JOptionPane.showMessageDialog(this, mazeno.getText() + " isnt a valid integer for the maze number");
	        return;
	    }
		try{
	        Integer.parseInt(numofRows.getText());
	    }catch(NumberFormatException e){
	        JOptionPane.showMessageDialog(this, numofRows.getText() + " isnt a valid integer for the number of rows");
	        return;
	    }
		try{
	        Integer.parseInt(numofCols.getText());
	    }catch(NumberFormatException e){
	        JOptionPane.showMessageDialog(this, numofCols.getText() + " isnt a valid integer for the number of columns");
	        return;
	    }
		int rows = Integer.parseInt(numofRows.getText());
		int cols = Integer.parseInt(numofCols.getText());
		int mazes = Integer.parseInt(mazeno.getText());
		MyFrame frame = new MyFrame(rows, cols, mazes, boxoptions.getSelectedItem().toString());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		this.dispose();
		
	}
	
}
