package cWS;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

public class cwSegmentation {
	/*
	  * 通过递归得到某一路径下所有的目录及其文件
	*/
	public static void getFiles(String filePath){
	  File root = new File(filePath);
	    File[] files = root.listFiles();
	  for(File file:files){
	     if(file.isDirectory()){
	      /*
	       * 递归调用
	       */
	      getFiles(file.getAbsolutePath());
	     }else{
	    	 try{
	    		 String filename=file.getAbsolutePath();
	    		 dfprocess(filename);
	    	 }catch(Exception e){
	    		 e.printStackTrace();
	    	 }	      
	     }     
	   }
   }
	
	
	public static void dfprocess(String filename) throws IOException {	
		String[] record=FileIO.ReadFile(filename,"utf-8").split("\n");
		System.out.println("该文件共有记录"+record.length+"条");
		for (int i = 0; i < record.length; i++) {
			if (record[i].length()<1) {
				continue;
			}
			//分词：
			List<Term> termList = ToAnalysis.parse(record[i]);
			String out="";
			for (Term term:termList) {
				String ele=term.toString();
				if (ele.length()<2||!ele.contains("/")) {
//					continue;
				}else {
					ele=ele.split("/")[0];
				}
				ele=ele.trim();
				out+=ele+" ";	
			}
			////写文件：
			StringBuffer result=new StringBuffer();
			result.append(out.trim()+"\n");
			try{
				FileIO.WriteFile("./data/CorpusSeg.txt", result.toString(), true);
			}catch(Exception e){
				e.printStackTrace();
		   }
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		String path="./data/Corpus/";
		cwSegmentation.getFiles(path);
	}
}
