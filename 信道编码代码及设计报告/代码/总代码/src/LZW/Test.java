package LZW;

import java.io.File;

public class Test {

	
	public static void main(String[] args)
	{
		Compress com = new Compress();
		Uncompress ucom = new Uncompress();
		
		File file1 = new File("data1.txt"); //��ѹ�����ļ�
		File file2 = new File("data2.txt"); //ѹ�������ļ�
		File file3 = new File("data3.txt"); //��ѹĿ¼�ļ�
		
		com.compress(file1,file2); //�ļ�ѹ���ķ���
//		ucom.uncompress(file2, file3);//�ļ���ѹ����
		
	}
	
	
	
	
	
}
