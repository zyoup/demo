package demo1;

import java.io.File;

/**
 *文件夹遍历
 *  递归
 *  递归的条件
 *    递归体
 *    递归的结束条件
 *    求阶乘
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
	   File f=new File("C:\\Users\\hp\\Desktop\\新建文件夹");
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
			  //判断 如果是文件夹继续遍历
			  if(file.isDirectory()){
				  showFile(file,leval+1);
			  }else{//不是文件夹
				  //是文件 就结束
//				  System.out.println("是文件"+file.getName());
			  }
			  return file.getName();
		  }
		return "1";
	}
}

