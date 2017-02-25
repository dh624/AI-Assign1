import java.util.*;

public class Heap {
	private ArrayList<State> heap;
	private int size;


	public Heap() {
		this.heap = new ArrayList<State>();
		size = 0;
	}

	private int left(int index) {
		int l = (2 * index) + 1;
		if(l < this.heap.size()) {
			return l;
		} else {
			return -1;
		}
	}

	private int right(int index) {
		int r = (2 * index) + 2;
		if(r < this.heap.size()) {
			return r;
		} else {
			return -1;
		}
	}

	private int parent(int index) {
		int p = (index-1)/2;
		if(p == 0) {
			return -1;
		} else {
			return p;
		}
	}

	private boolean compareStates(State a, State b) {
		return (a.f_s - a.g_s) > (b.f_s - b.g_s);
	}

	public int size() {
		return this.heap.size();
	}

	public void insert(State element) {
		this.heap.add(element);
		size++;
		heapifyUp(size-1);
	}

	public void heapifyUp(int index) {
		int parent_index = parent(index);
		if(index>=0 && parent_index>=0 && compareStates(this.heap.get(parent_index), this.heap.get(index)) ) {
			State temp = this.heap.get(index);
			State parent = this.heap.get(parent_index);
			this.heap.set(index, parent);
			this.heap.set(parent_index, temp);
			heapifyUp(parent_index);
		}
	}

	public State extractMin() {
		if(size == 0) {
			return null;
		}

		State temp = this.heap.get(0);
		this.heap.set(0, this.heap.get(size-1));
		size--;
		this.heap.remove(size);
		this.heapifyDown(0);
		return temp;
	}

	public void heapifyDown(int index) {
		int child_index = left(index);
		int child_index2 = right(index);
		if(child_index>=0 && child_index2>=0 && compareStates(this.heap.get(child_index), this.heap.get(child_index2)) ) {
			child_index = child_index2;
		}
		if(child_index>0) {
			State temp = this.heap.get(index);
			State child = this.heap.get(child_index);
			this.heap.set(index, child);
			this.heap.set(child_index, temp);
			heapifyDown(child_index);
		}
	}	
}