package demo1;

import java.io.File;

/**
 *�ļ��б���
 *  �ݹ�
 *  �ݹ������
 *    �ݹ���
 *    �ݹ�Ľ�������
 *    ��׳�
 *    n*(n-1)!
 *    method(n)
 *    if(n==1){
 *       return 1;
 *    }else{
 *        return n*method(n-1);
 *    }
 * D:\qf1804\jkl\ghj\dfg\abc\abc.txt
 * -jkl
 * --ghj
 * ---dfg
 * ----abc
 * -----abc.txt   
 *
 */
public class Test1 {
   public static void main(String[] args) {
	   File f=new File("C:\\Users\\hp\\Desktop\\�½��ļ���");
	   //showFile(f,1);
	   String show = showFile(f, 1);
	   System.out.println(show);
   }

	//private static void showFile(File f,int leval) {
   private static String showFile(File f,int leval) {
		  File[] files = f.listFiles();
		  for(File file:files){
			  //-
			  for(int i=0;i<leval;i++){//1  i=0  i<2
				  System.out.print("-");
			  }
			  System.out.println(file.getName());
			  //�ж� ������ļ��м�������
			  if(file.isDirectory()){
				  showFile(file,leval+1);
			  }else{//�����ļ���
				  //���ļ� �ͽ���
//				  System.out.println("���ļ�"+file.getName());
			  }
			  return file.getName();
		  }
		return "1";
	}
}

