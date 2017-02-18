
public class State {
	public State leftState;
	public State rightState;
	public State parentState;
	public int f_s;
	public int g_s;
	public int h_s;
	public int x;
	public int y;
	
	public State(int x, int y){
		this.x = x;
		this.y = y;
		this.leftState = null;
		this.rightState = null;
		this.parentState = null;
		this.f_s = 0;
		this.g_s = 0;
		this.h_s = 0;
		
	}
}
