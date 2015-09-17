package forbid;

import java.util.*;
import java.io.*;

public class Tools {
	private static String inputFileName;
	private static String outputFileName;
	private static int cnt = 1;
	
	public static void initTools(String inputfile, String outputfile){
		inputFileName  = inputfile;
		outputFileName = outputfile;
	}
	
	public static Graph initGraph() throws Exception{
		File  file  = new File(inputFileName);
		
		FileReader     f_in    = new FileReader(file);
		BufferedReader buff_in = new BufferedReader(f_in);
		String         s       = buff_in.readLine();
		
		String[]	   s_arr   = s.split(" ");
		
		int nodeSum = Integer.parseInt(s_arr[1]);
		int edgeSum = Integer.parseInt(s_arr[2]);
		
		Graph graph = new Graph(nodeSum, edgeSum);
		
		while( (s = buff_in.readLine()) != null){
			String[] string_arr = s.split(" ");
			graph.addEdge(Integer.parseInt(string_arr[1]), Integer.parseInt(string_arr[2]));
		}
		graph.inital();
		buff_in.close();
		f_in.close();
		return graph;
	}
	public static void outputResult(String s, int value, String filename) throws Exception{
		File  file    = new File(outputFileName);
		File  newfile = new File(filename);
		
 		FileWriter f_out  = new FileWriter(file, true);
 		FileWriter f_out_ = new FileWriter(newfile, true);
 		
		BufferedWriter buff_out  = new BufferedWriter(f_out);
		BufferedWriter buff_out_ = new BufferedWriter(f_out_);
		
		buff_out.write(s);
		
		String[] ss = s.split(" ");
		buff_out_.write((cnt++)+" "+ss[1]+" "+value);
		buff_out_.newLine();
		
		buff_out.flush();
		buff_out_.flush();
		
		buff_out.close();
		buff_out_.close();
		f_out.close();
		f_out_.close();
	}
	public static void resultoutput(int value) throws Exception{
		File file  = new File(outputFileName);
		FileWriter f_out = new FileWriter(file,true);
		BufferedWriter buff_out = new BufferedWriter(f_out);
		buff_out.write("maxvalue: "+value);
		buff_out.flush();
		buff_out.close();
		f_out.close();
	}
}
