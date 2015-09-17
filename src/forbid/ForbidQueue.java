package forbid;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ForbidQueue {
	
	private ConcurrentLinkedQueue<int[]> forbidQueue = new ConcurrentLinkedQueue();
	private int forbidSteps;
	
	public ForbidQueue(int x){
		forbidSteps = x;
	}
	
	public void addNode(int item){
		int[] newNode = new int[2];
		newNode[0] = item+1;
		newNode[1] = forbidSteps;
		forbidQueue.add(newNode);
	}
	public void updateQueue(NoforbidArr noForbidArr){
		int[] i = forbidQueue.peek();
		if(i[1] == 0){
			i = forbidQueue.poll();
			noForbidArr.add(i[0]-1);
		}
		for(Iterator iter = forbidQueue.iterator(); iter.hasNext();){
			int tmp = ((int[])iter.next())[1]--;
		}
		for(Iterator iter1 = forbidQueue.iterator(); iter1.hasNext(); ){
			iter1.next();
		}
	}
}