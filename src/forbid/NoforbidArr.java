package forbid;

import java.util.ArrayList;
import java.util.Iterator;



public class NoforbidArr {
	private int V;
	public ArrayList<Integer> queenNoforbid=new ArrayList<Integer>();
	
	public NoforbidArr(int v){
		this.V = v;
		this.initial();
	}
	public void initial(){
		for(int i=0;i<V;i++){
			queenNoforbid.add(i);
		}
	}
	public void add(int row){
		queenNoforbid.add(row);
	}
			
	public void remove(Integer row){
		queenNoforbid.remove(row);
	}
}
