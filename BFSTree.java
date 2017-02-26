import java.awt.Color;

public class BFSTree {
	public State head;
	public State current;
	//heap goes here
	//public int depth;
	
	public BFSTree(){
		//this.depth = 0;
		this.head = null;
		this.current = null;
	}


public void exploreleft(){
	if(current.x -1 < 0){
		return; //hit a boundary
	}
	if(MyFrame.gridpanel[current.x-1][current.y].getBackground().equals(Color.BLACK)){
		return; //hit a wall
	}
	if(MyFrame.gridpanel[current.x-1][current.y].getBackground().equals(Color.BLUE)){
		return; //already explored
	}
	else{
		MyFrame.gridpanel[current.x-1][current.y].setBackground(Color.BLUE);
		State newstate = new State(current.x-1,current.y,current);
		if(current.next == null){
			current.next = newstate;
		}else{
			State temp = current.next;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newstate;
		}
		MyFrame.heap.insert(newstate);
	}
	return;
}
public void exploreright(){
	if(current.x+1 < 0){
		return; //hit a boundary
	}
	if(MyFrame.gridpanel[current.x+1][current.y].getBackground().equals(Color.BLACK)){
		return; //hit a wall
	}
	if(MyFrame.gridpanel[current.x+1][current.y].getBackground().equals(Color.BLUE)){
		return; //already explored
	}
	else{
		MyFrame.gridpanel[current.x+1][current.y].setBackground(Color.BLUE);
		State newstate = new State(current.x+1,current.y,current);
		if(current.next == null){
			current.next = newstate;
		}else{
			State temp = current.next;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newstate;
		}
		MyFrame.heap.insert(newstate);
	}
	return;	
}
public void exporetop(){
	if(current.y +1 < 0){
		return; //hit a boundary
	}
	if(MyFrame.gridpanel[current.x][current.y+1].getBackground().equals(Color.BLACK)){
		return; //hit a wall
	}
	if(MyFrame.gridpanel[current.x][current.y+1].getBackground().equals(Color.BLUE)){
		return; //already explored
	}
	else{
		MyFrame.gridpanel[current.x][current.y+1].setBackground(Color.BLUE);
		State newstate = new State(current.x,current.y+1,current);
		if(current.next == null){
			current.next = newstate;
		}else{
			State temp = current.next;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newstate;
		}
		MyFrame.heap.insert(newstate);
	}
	return;
}
public void explorebottom(){
	if(current.y-1 < 0){
		return; //hit a boundary
	}
	if(MyFrame.gridpanel[current.x][current.y-1].getBackground().equals(Color.BLACK)){
		return; //hit a wall
	}
	if(MyFrame.gridpanel[current.x][current.y-1].getBackground().equals(Color.BLUE)){
		return; //already explored
	}
	else{
		MyFrame.gridpanel[current.x][current.y-1].setBackground(Color.BLUE);
		State newstate = new State(current.x,current.y-1,current);
		if(current.next == null){
			current.next = newstate;
		}else{
			State temp = current.next;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newstate;
		}
		MyFrame.heap.insert(newstate);
	}
	return;
}
public void updateCurrent(){
	//change current based on min
	this.current = MyFrame.heap.extractMin();
}
}



