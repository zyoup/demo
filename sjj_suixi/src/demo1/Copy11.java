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
//	 FileInputStream fis=new FileInputStream(new File("C:\\Users\\hp\\Desktop\\�½��ļ���\\del.txt"));
//	   BufferedInputStream bis=new BufferedInputStream(fis);
//	   FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\hp\\Desktop\\�½��ļ���\\del2.txt"));
//	   BufferedOutputStream bos=new BufferedOutputStream(fos); //size  8192  1024*8
	
	   BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//ѡ����ʵ��� copy
			   FileReader fr=new FileReader(new File("C:\\Users\\hp\\Desktop\\test\\�͸�3�����Լ�.txt") );
			   br = new BufferedReader(fr);
			   FileWriter fw=new FileWriter(new File("C:\\Users\\hp\\Desktop\\test\\del2.txt"),true);
			   bw = new BufferedWriter(fw);
			   //��������  ����ѵ�����ĩβ���򷵻� null 
			    String s = null;
			    while((s=br.readLine())!=null){
			    	String s1="ooxx";
			    	bw.write(s1);
			    	//д
			    	bw.write(s);
			    	//д����
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
				 //����
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
		    
		  
		  
		   System.out.println("�������");

	   
	   
	   
	   
	   
	}
}
