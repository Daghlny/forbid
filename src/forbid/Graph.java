package forbid;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph extends Bag{
	private final int V;
	private int E;
	private int fun=0;
	private Bag<Integer>[] adj;
	private  ArrayList<Integer> changeArr;
	private  ArrayList<Integer> resultArr;
	public int maxfun=0;
	public Graph(int V, int E){
		this.V=V;
		this.E=E;
		adj=(Bag<Integer>[]) new Bag[V+1];
		for(int v=1;v<V+1;v++){
			adj[v]=new Bag<Integer>();
			adj[v].getNode().setItem(v);
		}
		resultArr = new ArrayList<Integer>();
		changeArr = new ArrayList<Integer>();
	}
	public void addEdge(int v,int w){
		try {
			adj[v].add(w);
			adj[w].add(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		E++;
	}
	public void inital(){
		for(int i=1;i<V+1;i++){
			resultArr.add(0);	
		}
		
		int num = 0;
		Bag.Node current;
		for(int i=1;i<V+1;i++){
				
			Bag.Node nodeone=adj[i].getNode();
			for(current=nodeone.next;current!=null;current=current.next){
				num++;
			}	
			changeArr.add(num);	
			num=0;	
		}
		
		
	}
	public void updateChange(int t){
		int i=t+1;
		Bag.Node nodeone=adj[i].getNode();		
		Bag.Node current = null;
		changeArr.set((int)nodeone.item-1, -(changeArr.get((int) nodeone.item-1)));
		for(current=nodeone.next;current!=null;current=current.next){
			if(resultArr.get((int) current.item-1)==resultArr.get((int) nodeone.item-1)){
				int temp=changeArr.get((int) current.item-1)+2;
				changeArr.set((int) current.item-1, temp);
			}
			else{
				int temp=changeArr.get((int) current.item-1)-2;
				changeArr.set((int) current.item-1, temp);
			}
			
		}
		
		
	}
	public int maxNum(NoforbidArr no){
		int num=1;
		
		ArrayList<Integer> noqueue=no.queenNoforbid;
				 
		Iterator<Integer> iter = noqueue.iterator(); 
		int index = noqueue.get(0);
		int maxnum=index;
		int value = changeArr.get(index);
		while (iter.hasNext()) { 
			 int element_index = iter.next();
			 int temp = changeArr.get( element_index);
			 if(temp > value){
				 value = temp;
				 maxnum=element_index;
			 }
			 num++;	
		 }
		if(resultArr.get(maxnum)==0){
			resultArr.set(maxnum, 1);
		}
		else{
			resultArr.set(maxnum, 0);
		}
		return maxnum;
		
	}
	public String result(int detal){
		
		int tempfun = changeArr.get(detal);
		String result="";
		fun +=tempfun;
		
		if(fun>maxfun){
			maxfun=fun;
		}
		for(int i=0;i<V;i++){
			result+=resultArr.get(i);
			}
		return  result+" "+fun+" ";
	}
	public int getNodeSum(){
		return V;
	}
}
