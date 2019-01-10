package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BatchModificationOfTXT {
	public static void main(String[] args) {
		
		String name="";//源文件名
		String new_name="";//新建文件名
		String projectName="";//项目名称
		String organizationName="";//单位名称
		String year="2018";//年份
		String month="";//月份
		String batch ="";//批次
		String remarks ="";//备注
		

//		String folderName="";//文件夹名称
		
//		String path="C:\\Users\\hp\\Desktop\\test";//测试源文件夹路径
//		String new_path="C:\\Users\\hp\\Desktop\\test2";//测试目标文件夹路径
		
//		String path="H:\\濉溪县2017年度和2018年度所有发放批次明细\\2017年度所有批次明细";//2017源文件夹路径
//		String new_path="H:\\濉溪县项目（程序）\\2017";//2017目标文件夹路径
		String path="H:\\濉溪县2017年度和2018年度所有发放批次明细\\2018年度所有批次明细，截止到2018.12.18日";//2018源文件夹路径
		String new_path="H:\\濉溪县项目（程序）\\2018";//2018目标文件夹路径
		File file = new File(path);
		ArrayList<String> fileNameList = new ArrayList<>();//以String存储文件名
		getFileName(file,fileNameList);
		//遍历文件名
		for (String fileName : fileNameList) {
			name=fileName;
			//处理文件名
			//eg:FTP01_262001_2月2批次第四期紧急慰藉项目资金_计划生育家庭奖励扶助资金_信用社_韩村镇_20181218153008
			String[] split = fileName.split("_");
			int num=0;//对"_"计数
			for (String splitName : split) {
				if(num==2) {
					/*
					 * 在月份中有所给文档名有“月”和“月份”
					 * 处理获取月份
					 */
					if("月份".equals(splitName.substring(1, 3)) ||"月份".equals(splitName.substring(2, 4))) {
						//月份
						if("月份".equals(splitName.substring(1, 3)) && "批".equals(splitName.substring(4, 5))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(3, 4);
							remarks=splitName.substring(6);
						}else if(!"月份".equals(splitName.substring(1, 3)) && "批".equals(splitName.substring(5, 6))) {
							month = splitName.substring(0, 2);
							batch=splitName.substring(4, 5);
							remarks=splitName.substring(7);
						}else if("月份".equals(splitName.substring(1, 3)) && !"批".equals(splitName.substring(4, 5))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(3, 5);
							remarks=splitName.substring(7);
						}else {
							month = splitName.substring(0, 2);
							batch=splitName.substring(4, 6);
							remarks=splitName.substring(8);
						}
					}else {
						//月
						if("月".equals(splitName.substring(1, 2)) && "批".equals(splitName.substring(3, 4))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(2, 3);
							remarks=splitName.substring(5);
						}else if(!"月".equals(splitName.substring(1, 2)) && "批".equals(splitName.substring(4, 5))) {
							month = splitName.substring(0, 2);
							batch=splitName.substring(3, 4);
							remarks=splitName.substring(6);
						}else if("月".equals(splitName.substring(1, 2)) && !"批".equals(splitName.substring(3, 4))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(2, 4);
							remarks=splitName.substring(6);
						}else {
							month = splitName.substring(0, 2);
							batch=splitName.substring(3, 5);
							remarks=splitName.substring(7);
						}
					}
				}
				if(num==3) {
					new_name=splitName+".txt";
				}
				if(num==5) {
					organizationName=splitName;
				}
				num++;
			}
			//System.out.println(name+"\t"+new_name+"\t"+projectName+"\t"+organizationName+"\t"+year+"\t"+month+"\t"+batch+"\t"+remarks);
//			新建文件夹批量写入所需文档
			newWriteTXT(path,new_path,name,new_name,projectName,organizationName,year,month,batch,remarks);
		}
	}
	
	/**
	 * 新建文件件，在文件夹中新建文本文档，按照需求格式处理输入至所要求的文本文件中
	 * eg:
	 * 项目名称^单位名称^年份^月份^批次^未知名1^未知名2^姓名^身份证号^一卡通账号^补贴金额^备注
	 * 残疾就业^百善镇^2017^2^4^48635070338C2ED7E050007F01007952^340621030116069^桑开銮^340621196203183290^10010894404510000000016^1200^残疾人专职委员工资
	 * @param new_path
	 */
	private static void newWriteTXT(String path,String new_path,String name, String new_name, String projectName, String organizationName,
			String year, String month, String batch, String remarks) {
		//int num=0;//写入到文本文件的行数
		int line=0;//源文本文件的行数
		//new_path+=new_name;
		File file = new File(new_path+"/"+new_name);
		//创建文件
		//先判断该文件是否存在
		if(!file.exists()) {
			int low=0;//原文本文件由"^"分的列数
//			System.out.println("原路径"+path+"/"+name);
//			System.out.println("目标路径"+new_path+"/"+new_name);
			BufferedReader br=null;
			BufferedWriter bw=null;
			try {
				FileReader fr = new FileReader(new File(path+"/"+name));
				br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(new File(new_path+"/"+new_name),true);
				bw = new BufferedWriter(fw);
				String s=null;//临时字符串
				while((s=br.readLine())!=null) {
					if(line==0) {
				    	//写
				    	bw.write("项目名称^单位名称^年份^月份^批次^未知名1^未知名2^姓名^身份证号^一卡通账号^补贴金额^备注");
				    	//写换行
				    	bw.newLine();
				    	line++;
						//处理源文本文件第一行，获取项目名
				    	String s1=s;
				    	System.out.println(s1);
						String[] split = s1.split("\\^");
						for (String line_1_split : split) {
							if(low==4) {
								projectName=line_1_split;
								System.out.println(projectName);
							}
							low++;
								
						}
					}else {
						/*向目标文本文件添加所需字符串前半部
						 * eg:项目名称^单位名称^年份^月份^批次^
						 */
				    	String fistString=projectName+"^"+organizationName+"^"+year+"^"+month+"^"+batch+"^";
						/*向目标文本文件添加所需字符串后半部
						 * eg:^备注
						 */
				    	String lastString="^"+remarks;
				    	//写
				    	bw.write(fistString+s+lastString);
				    	//写换行
				    	bw.newLine();
					}
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
			
		}else {
			int low=0;//原文本文件由"^"分的列数
//			System.out.println("原路径"+path+"/"+name);
//			System.out.println("目标路径"+new_path+"/"+new_name);
			BufferedReader br=null;
			BufferedWriter bw=null;
			try {
				FileReader fr = new FileReader(new File(path+"/"+name));
				br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(new File(new_path+"/"+new_name),true);
				bw = new BufferedWriter(fw);
				String s=null;//临时字符串
				while((s=br.readLine())!=null) {
					if(line==0) {
						line++;
						//处理源文本文件第一行，获取项目名
				    	String s1=s;
				    	System.out.println(s1);
						String[] split = s1.split("\\^");
						for (String line_1_split : split) {
							if(low==4) {
								projectName=line_1_split;
								System.out.println(projectName);
							}
							low++;
								
						}
					}else {
						/*向目标文本文件添加所需字符串前半部
						 * eg:项目名称^单位名称^年份^月份^批次^
						 */
				    	String fistString=projectName+"^"+organizationName+"^"+year+"^"+month+"^"+batch+"^";
						/*向目标文本文件添加所需字符串后半部
						 * eg:^备注
						 */
				    	String lastString="^"+remarks;
				    	//写
				    	bw.write(fistString+s+lastString);
				    	//写换行
				    	bw.newLine();
					}
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
			
		}
	}


	/*
	 * 获取文件夹下的文件名称
	 */
	private static void getFileName(File file, ArrayList<String> fileNameList) {
		String name = "";// 文件名称
		File[] listFiles = file.listFiles();
		// 遍历文件夹下所有内容
		for (File file2 : listFiles) {
			// 遍历获取文件
			if (file2.isFile()) {
				name = file2.getName();// 获取文件名
				fileNameList.add(name);
			}
			if (file2.isDirectory()) {
				String name2 = file2.getName();//获取目录名
				getFileName(file2, fileNameList);
			}
		}
		return;
	}

}
