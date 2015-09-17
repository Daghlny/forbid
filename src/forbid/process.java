package forbid;


public class process {
	public static void main(String[] args) throws Exception{
		int step=0;
		Tools.initTools("input.txt", "output.txt");
		Graph  tspGraph=Tools.initGraph();
		ForbidQueue forbidQueue=new ForbidQueue(20);
		NoforbidArr noforbidArr=new NoforbidArr(tspGraph.getNodeSum());
		while(step <= 5000 && noforbidArr.queenNoforbid.size()!=0){
			int num=tspGraph.maxNum(noforbidArr);
			
			String result=tspGraph.result(num);
			tspGraph.updateChange(num);
			
			Integer rem=new Integer(num);
			noforbidArr.remove(rem);
			forbidQueue.addNode(num);
			forbidQueue.updateQueue(noforbidArr);
			Tools.outputResult(result, tspGraph.maxfun,"result.txt");
			
			step++;
			
		}
		
		int maxfun=tspGraph.maxfun;
		Tools.resultoutput(maxfun);
		
	}

}
