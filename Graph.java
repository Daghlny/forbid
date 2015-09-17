package forbid;



import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.introcs.In;
public class Graph {
	private final int V;//节点数
	private int E;//边数
	private int fun=0;
	private Bag<Integer>[] adj;
	private  ArrayList<Integer> changeArr;
	private  ArrayList<Integer> resultArr;
	public Graph(int V, int E){
		this.V=V;
		this.E=E;
		adj=(Bag<Integer>[]) new Bag[V+1];
		for(int v=1;v<V+1;v++){
			adj[v]=new Bag<Integer>();
		}
	}
	public void addEdge(int v,int w){
		System.out.println(1);
		try {
			adj[v].add(w);
			adj[w].add(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	public void updateChange(int i){
		Bag.Node nodeone=adj[i].getNode();		
		Bag.Node current = null;
		changeArr.set((int) current.item, -(changeArr.get((int) current.item)));
		for(current=nodeone.next;current!=null;current=current.next){
			
			if(resultArr.get((int) current.item)!=resultArr.get((int) nodeone.item)){
				int temp=changeArr.get((int) nodeone.item)+2;
				changeArr.set((int) nodeone.item, temp);
			}
			else{
				int temp=changeArr.get((int) nodeone.item)-2;
				changeArr.set((int) nodeone.item, temp);
			}
			
		}
		
	}
	public int maxNum(){
		int num=0;
		
		int temp=changeArr.get(0);
		for(int i=2;i<V+1;i++){
			if(changeArr.get(i)>temp)
				temp=changeArr.get(i);
				num=i;
		}
		if(resultArr.get(num)==0){
			resultArr.set(num, 1);
		}
		else{
			resultArr.set(num, 0);
		}
		return temp;
	}
	public String result(int detal){
		
		String result="";
		fun+=detal;
		for(int i=1;i<V+1;i++){
			result+=resultArr.get(i);
		}
		return  result+" "+fun;
	}
	

}

/*public class Graph {
	
	private final int V;//节点数
	private int E;//边数
	private Bag<Integer>[] adj;
	
	public Graph(int V){
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int v=0;v<V;v++){
			adj[v]=new Bag<Integer>();
		}
	}
	
	//从文件读取
	public Graph(In in){
		this(in.readInt());
		int E=in.readInt();
		for(int i=0;i<E;i++){
			
			int v=in.readInt();
			int w=in.readInt();
			addEdge(v,w);
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(int v,int w){
		try {
			adj[v].add(w);
			adj[w].add(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return  adj[v];
	}
	
	public static int degree(Graph G,int v){
		int degree=0;
		for(int w:G.adj(v)) degree++;
		return degree;
	}
	
	public static int maxDegree(Graph G){
		int max=0;
		int current=0;
		for(int v=0;v<G.V();v++){
			current=degree(G,v);
			if(current>max){
				max=current;
			}
		}
		return max;
	}
	
	public static double avgDegree(Graph G){
		return 2.0*G.E()/G.V();
	}
	
	public static int numberOfSelfLoops(Graph G){
		int count=0;
		for(int v=0;v<G.V();v++){
			for(int w:G.adj(v)){
				if(v==w) count++;
			}
		}
		return count/2;
	}*/

	/*@Override
	public String toString() {
		String s=V+" vertices, " + E + " edges\n";
		for(int v=0;v<V;v++){
			s+=v+": ";
			for(int w:this.adj(v)){
				s+=w+" ";
			}
			s+="\n";
		}
		return s;
	}*/
	
	
	/*public void InitialArc(){
		int num = 0;
		Bag.Node current;
		for(int i=0;i<V;i++){
			
			Bag.Node nodeone=adj[i].getNode();
			for(current=nodeone.next;current!=null;current=current.next){
				//System.out.println("test");
				num++;
				
			}
			
			nodeone.setGreenArc(num);
			//System.out.println("初始绿边"+nodeone.GreenArc+"\n");
			num=0;	
		}*/
		/*for(int i=0;i<V;i++){
			Bag.Node nodeone=adj[i].getNode();
			for(current=nodeone.next;current!=null;current=current.next){
				current.GreenArc=adj[(int) current.item].getNode().GreenArc;
				
			}
			
			System.out.println("初始绿边"+nodeone.GreenArc+"\n");
			num=0;	
			
		}
		
		
	}*/
	/*public void setArctwo(int i){
		Bag.Node nodeone=adj[i].getNode();
		int temp=nodeone.GreenArc;
		nodeone.GreenArc=nodeone.RedArc;
		nodeone.RedArc=temp;
		Bag.Node current;
		for(current=nodeone.next;current!=null;current=current.next){
			if(current.Sample!=nodeone.Sample){
				adj[(int) current.item].getNode().GreenArc-=1;
				adj[(int) current.item].getNode().RedArc+=1;
				
			}
			else{
				adj[(int) current.item].getNode().RedArc-=1;
				adj[(int) current.item].getNode().GreenArc+=1;
				
			}
			
		}
		
	}
	public void SetValueChange(){
		int num = 0;
		Bag.Node current;
		for(int i=0;i<V;i++){
			
			Bag.Node nodeone=adj[i].getNode();
			nodeone.valueChange();
			
			//System.out.println("change"+i+": "+nodeone.change+"\n");
				
		}
		
	}
	
	public static void main(String[] args){
		Graph graph= new Graph(4);
		graph.addEdge(1, 2);
		graph.addEdge(0, 2);
		graph.addEdge(3, 1);
		
		for(int i:graph.adj(1)){
			System.out.println("节点:"+i);
		}
		
		System.out.println(graph);
		
	}
}*/
