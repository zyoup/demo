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
		
		String name="";//Դ�ļ���
		String new_name="";//�½��ļ���
		String projectName="";//��Ŀ����
		String organizationName="";//��λ����
		String year="2018";//���
		String month="";//�·�
		String batch ="";//����
		String remarks ="";//��ע
		

//		String folderName="";//�ļ�������
		
//		String path="C:\\Users\\hp\\Desktop\\test";//����Դ�ļ���·��
//		String new_path="C:\\Users\\hp\\Desktop\\test2";//����Ŀ���ļ���·��
		
//		String path="H:\\�Ϫ��2017��Ⱥ�2018������з���������ϸ\\2017�������������ϸ";//2017Դ�ļ���·��
//		String new_path="H:\\�Ϫ����Ŀ������\\2017";//2017Ŀ���ļ���·��
		String path="H:\\�Ϫ��2017��Ⱥ�2018������з���������ϸ\\2018�������������ϸ����ֹ��2018.12.18��";//2018Դ�ļ���·��
		String new_path="H:\\�Ϫ����Ŀ������\\2018";//2018Ŀ���ļ���·��
		File file = new File(path);
		ArrayList<String> fileNameList = new ArrayList<>();//��String�洢�ļ���
		getFileName(file,fileNameList);
		//�����ļ���
		for (String fileName : fileNameList) {
			name=fileName;
			//�����ļ���
			//eg:FTP01_262001_2��2���ε����ڽ���ο����Ŀ�ʽ�_�ƻ�������ͥ���������ʽ�_������_������_20181218153008
			String[] split = fileName.split("_");
			int num=0;//��"_"����
			for (String splitName : split) {
				if(num==2) {
					/*
					 * ���·����������ĵ����С��¡��͡��·ݡ�
					 * �����ȡ�·�
					 */
					if("�·�".equals(splitName.substring(1, 3)) ||"�·�".equals(splitName.substring(2, 4))) {
						//�·�
						if("�·�".equals(splitName.substring(1, 3)) && "��".equals(splitName.substring(4, 5))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(3, 4);
							remarks=splitName.substring(6);
						}else if(!"�·�".equals(splitName.substring(1, 3)) && "��".equals(splitName.substring(5, 6))) {
							month = splitName.substring(0, 2);
							batch=splitName.substring(4, 5);
							remarks=splitName.substring(7);
						}else if("�·�".equals(splitName.substring(1, 3)) && !"��".equals(splitName.substring(4, 5))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(3, 5);
							remarks=splitName.substring(7);
						}else {
							month = splitName.substring(0, 2);
							batch=splitName.substring(4, 6);
							remarks=splitName.substring(8);
						}
					}else {
						//��
						if("��".equals(splitName.substring(1, 2)) && "��".equals(splitName.substring(3, 4))) {
							month = splitName.substring(0, 1);
							batch=splitName.substring(2, 3);
							remarks=splitName.substring(5);
						}else if(!"��".equals(splitName.substring(1, 2)) && "��".equals(splitName.substring(4, 5))) {
							month = splitName.substring(0, 2);
							batch=splitName.substring(3, 4);
							remarks=splitName.substring(6);
						}else if("��".equals(splitName.substring(1, 2)) && !"��".equals(splitName.substring(3, 4))) {
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
//			�½��ļ�������д�������ĵ�
			newWriteTXT(path,new_path,name,new_name,projectName,organizationName,year,month,batch,remarks);
		}
	}
	
	/**
	 * �½��ļ��������ļ������½��ı��ĵ������������ʽ������������Ҫ����ı��ļ���
	 * eg:
	 * ��Ŀ����^��λ����^���^�·�^����^δ֪��1^δ֪��2^����^���֤��^һ��ͨ�˺�^�������^��ע
	 * �м���ҵ^������^2017^2^4^48635070338C2ED7E050007F01007952^340621030116069^ɣ����^340621196203183290^10010894404510000000016^1200^�м���רְίԱ����
	 * @param new_path
	 */
	private static void newWriteTXT(String path,String new_path,String name, String new_name, String projectName, String organizationName,
			String year, String month, String batch, String remarks) {
		//int num=0;//д�뵽�ı��ļ�������
		int line=0;//Դ�ı��ļ�������
		//new_path+=new_name;
		File file = new File(new_path+"/"+new_name);
		//�����ļ�
		//���жϸ��ļ��Ƿ����
		if(!file.exists()) {
			int low=0;//ԭ�ı��ļ���"^"�ֵ�����
//			System.out.println("ԭ·��"+path+"/"+name);
//			System.out.println("Ŀ��·��"+new_path+"/"+new_name);
			BufferedReader br=null;
			BufferedWriter bw=null;
			try {
				FileReader fr = new FileReader(new File(path+"/"+name));
				br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(new File(new_path+"/"+new_name),true);
				bw = new BufferedWriter(fw);
				String s=null;//��ʱ�ַ���
				while((s=br.readLine())!=null) {
					if(line==0) {
				    	//д
				    	bw.write("��Ŀ����^��λ����^���^�·�^����^δ֪��1^δ֪��2^����^���֤��^һ��ͨ�˺�^�������^��ע");
				    	//д����
				    	bw.newLine();
				    	line++;
						//����Դ�ı��ļ���һ�У���ȡ��Ŀ��
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
						/*��Ŀ���ı��ļ���������ַ���ǰ�벿
						 * eg:��Ŀ����^��λ����^���^�·�^����^
						 */
				    	String fistString=projectName+"^"+organizationName+"^"+year+"^"+month+"^"+batch+"^";
						/*��Ŀ���ı��ļ���������ַ�����벿
						 * eg:^��ע
						 */
				    	String lastString="^"+remarks;
				    	//д
				    	bw.write(fistString+s+lastString);
				    	//д����
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
			
		}else {
			int low=0;//ԭ�ı��ļ���"^"�ֵ�����
//			System.out.println("ԭ·��"+path+"/"+name);
//			System.out.println("Ŀ��·��"+new_path+"/"+new_name);
			BufferedReader br=null;
			BufferedWriter bw=null;
			try {
				FileReader fr = new FileReader(new File(path+"/"+name));
				br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(new File(new_path+"/"+new_name),true);
				bw = new BufferedWriter(fw);
				String s=null;//��ʱ�ַ���
				while((s=br.readLine())!=null) {
					if(line==0) {
						line++;
						//����Դ�ı��ļ���һ�У���ȡ��Ŀ��
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
						/*��Ŀ���ı��ļ���������ַ���ǰ�벿
						 * eg:��Ŀ����^��λ����^���^�·�^����^
						 */
				    	String fistString=projectName+"^"+organizationName+"^"+year+"^"+month+"^"+batch+"^";
						/*��Ŀ���ı��ļ���������ַ�����벿
						 * eg:^��ע
						 */
				    	String lastString="^"+remarks;
				    	//д
				    	bw.write(fistString+s+lastString);
				    	//д����
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
			
		}
	}


	/*
	 * ��ȡ�ļ����µ��ļ�����
	 */
	private static void getFileName(File file, ArrayList<String> fileNameList) {
		String name = "";// �ļ�����
		File[] listFiles = file.listFiles();
		// �����ļ�������������
		for (File file2 : listFiles) {
			// ������ȡ�ļ�
			if (file2.isFile()) {
				name = file2.getName();// ��ȡ�ļ���
				fileNameList.add(name);
			}
			if (file2.isDirectory()) {
				String name2 = file2.getName();//��ȡĿ¼��
				getFileName(file2, fileNameList);
			}
		}
		return;
	}

}
