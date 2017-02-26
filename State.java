
public class State {
	public State leftState;
	public State rightState;
	public State parentState;
	public int f_s;
	public int g_s;
	public int h_s;
	public int x;
	public int y;
	public State next;
	
	public State(int x, int y, State prev){
		this.x = x;
		this.y = y;
		this.parentState = prev;
		this.f_s = 0;
		this.g_s = 0;
		this.h_s = 0;
		this.next = null;
		//compute x and y
		if(prev == null){
			return;
		}
		if(MyFrame.algorithm.equals("Repeated A*")){
			this.g_s = prev.g_s +1;
			this.h_s = Math.abs((MyFrame.goal.x - x)) +Math.abs((MyFrame.goal.y - y));
			this.f_s =g_s +h_s;
		}else if(MyFrame.algorithm.equals("Backward A*")){
			
		}else if(MyFrame.algorithm.equals("Adaptive A*")){
			
		}else{
			return;
		}
	}
}
