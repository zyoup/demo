package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy11 {
public static void main(String[] args) throws Throwable {
//	 FileInputStream fis=new FileInputStream(new File("C:\\Users\\hp\\Desktop\\新建文件夹\\del.txt"));
//	   BufferedInputStream bis=new BufferedInputStream(fis);
//	   FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\hp\\Desktop\\新建文件夹\\del2.txt"));
//	   BufferedOutputStream bos=new BufferedOutputStream(fos); //size  8192  1024*8
	
	   BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//选择合适的流 copy
			   FileReader fr=new FileReader(new File("C:\\Users\\hp\\Desktop\\test\\送给3年后的自己.txt") );
			   br = new BufferedReader(fr);
			   FileWriter fw=new FileWriter(new File("C:\\Users\\hp\\Desktop\\test\\del2.txt"),true);
			   bw = new BufferedWriter(fw);
			   //处理数据  如果已到达流末尾，则返回 null 
			    String s = null;
			    while((s=br.readLine())!=null){
			    	String s1="ooxx";
			    	bw.write(s1);
			    	//写
			    	bw.write(s);
			    	//写换行
			    	bw.newLine();
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw!=null){
				 //关流
				   try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				 try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		    
		  
		  
		   System.out.println("操作完成");

	   
	   
	   
	   
	   
	}
}
