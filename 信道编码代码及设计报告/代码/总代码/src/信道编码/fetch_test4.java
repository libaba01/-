package �ŵ�����;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.*;

import lib.ConsoleTextArea;
import ����.ArithCode;
import ����.ConsoleTextArea1;
import ��ŵ.Test;
import ��ũ.ShannonEncoding;
import ��ŵ.list;


//1.�ӵ�ǰ�����ı����л�ȡ�ı���Ϣ������
//2.�����������н��������ǰ���ı�����


//public class fetch_text_suanshu{
//	public static void main(String[] args) {
//	new fetch_test4 ();
// }
//}


     public   class fetch_test4 extends JFrame {

							int count = 0;
	
							String[] NQ = null;
							
							float []py = null;
								
							int mount = 0;
							
							String []F2 = null;
							
							ArithCode a=new ArithCode();
							
							
						

		public fetch_test4() {

			
			//һ�������ı���һ���ı�����ʾ�������Ϣ
//			JButton sendBt;
//			JTextField inputField;
			JTextArea chatContent;
//			this.setLayout(new BorderLayout());
			chatContent = new JTextArea(12, 34); // ����һ���ı���
			// ����һ��������壬���ı�����Ϊ����ʾ���
			JScrollPane showPanel = new JScrollPane(chatContent);
			chatContent.setEditable(false);    // �����ı��򲻿ɱ༭
			JPanel inputPanel = new JPanel(); // ����һ��JPanel���
			
			JTextField inputField1 = new JTextField(12);  // ����һ���ı���
			JButton sendBt1 = new JButton("���Ÿ���");      // ����һ�����Ͱ�ť
			
			JTextField inputField2 = new JTextField(12);  // ����һ���ı���
			JButton sendBt2 = new JButton("����");      // ����һ�����Ͱ�ť
			
			JTextField inputField3 = new JTextField(12);  // ����һ���ı���
			JButton sendBt3 = new JButton("���Ÿ���");      // ����һ�����Ͱ�ť
			
			JTextField inputField4 = new JTextField(12);  // ����һ���ı���
			JButton sendBt4 = new JButton("�������г���");      // ����һ�����Ͱ�ť
			
			JTextField inputField5 = new JTextField(12);  // ����һ���ı���
			JButton sendBt5 = new JButton("��Ϣ����");      // ����һ�����Ͱ�ť
			chatContent.append("�������������");
			
			// Ϊ��ť1����¼�
						sendBt1.addActionListener(new ActionListener() { 
							// Ϊ��ť���һ�������¼�e
							public void actionPerformed(ActionEvent e) {
								// ��дactionPerformed����
								// ��ȡ������ı���Ϣ 
								
			
								
								String content = inputField1.getText(); 
								int con=Integer.parseInt(content);
								count=con;
								a.setN(con);
								
								
				            // �ж��������Ϣ�Ƿ�Ϊ��
								if (content != null && !content.trim().equals("")) {
				                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
									//���ı��������ƽ���볤�ͱ���Ч��															
										chatContent.append(count+"\n");																
									
								    } else {
				                    // ���Ϊ�գ���ʾ�������ݲ���Ϊ��
									chatContent.append("�������ݲ���Ϊ��" + "\n");
								}
//								inputField1.setText("");      // ��������ı���������Ϊ��
							}
						});
			
						// Ϊ��ť����¼�
						sendBt2.addActionListener(new ActionListener() { 
							// Ϊ��ť���һ�������¼�e
							public void actionPerformed(ActionEvent e) {
								// ��дactionPerformed����
								// ��ȡ������ı���Ϣ
								// ��дactionPerformed����
								// ��ȡ������ı���Ϣ 
								
							
								
								String s3 = inputField2.getText();
		                        String [] spString = s3.split("\\s+");
		                        NQ=spString;
								a.setNQ(NQ);
								
				            // �ж��������Ϣ�Ƿ�Ϊ��
								if (s3 != null && !s3.trim().equals("")) {
				                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
									chatContent.append("������ַ�Ϊ:");
										for(int i=0;i<NQ.length;i++) {
											chatContent.append(NQ[i]+"  ");
		
										}	
										chatContent.append("\n");
								    } else {
				                    // ���Ϊ�գ���ʾ�������ݲ���Ϊ��
									chatContent.append("�������ݲ���Ϊ��" + "\n");
								}
//								inputField1.setText("");      // ��������ı���������Ϊ��
							}
						});
						
			
						// Ϊ��ť����¼�
						sendBt3.addActionListener(new ActionListener() { 
							// Ϊ��ť���һ�������¼�e
							public void actionPerformed(ActionEvent e) {
								// ��дactionPerformed����
								// ��ȡ������ı���Ϣ
	                           								
								String content = inputField3.getText();  
								String s4 = inputField3.getText();
		                        String [] spString1 = s4.split("\\s+");
		                        float [] sp=new float[spString1.length];
		                        for(int i=0;i<spString1.length;i++)
		                        	sp[i]=Float.parseFloat(spString1[i]);
		                        py=sp;
		                        
								a.setPy(py);
		
						
								
				            // �ж��������Ϣ�Ƿ�Ϊ��
								if (s4 != null && !s4.trim().equals("")) {
				                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
									chatContent.append("�����ַ�����Ϊ:");
										for(int i=0;i<NQ.length;i++) {
											chatContent.append(py[i]+"  ");
											
										}		
										chatContent.append("\n");
								    } else {
				                    // ���Ϊ�գ���ʾ�������ݲ���Ϊ��
									chatContent.append("�������ݲ���Ϊ��" + "\n");
								}
//								inputField1.setText("");      // ��������ı���������Ϊ��
							}
						});
			
			
						// Ϊ��ť����¼�
						sendBt4.addActionListener(new ActionListener() { 
							// Ϊ��ť���һ�������¼�e
							public void actionPerformed(ActionEvent e) {
								// ��дactionPerformed����
								// ��ȡ������ı���Ϣ
	                   								 
								String content = inputField4.getText(); 
								int con=Integer.parseInt(content);
								mount=con;
								a.setM(mount);
		
						
								
				            // �ж��������Ϣ�Ƿ�Ϊ��
								if (content != null && !content.trim().equals("")) {
				                     // �����Ϊ�գ���������ı�׷�ӵ������촰��

											chatContent.append("�������г���Ϊ:"+mount+"  ");
											chatContent.append("\n");
								    } else {
				                    // ���Ϊ�գ���ʾ�������ݲ���Ϊ��
									chatContent.append("�������ݲ���Ϊ��" + "\n");
								}
//								inputField1.setText("");      // ��������ı���������Ϊ��
							}
						});
			
			
						// Ϊ��ť����¼�
						sendBt5.addActionListener(new ActionListener() { 
							// Ϊ��ť���һ�������¼�e
							public void actionPerformed(ActionEvent e) {
								// ��дactionPerformed����
								// ��ȡ������ı���Ϣ
	                   
								
								String content = inputField4.getText();  
								//�ַ�
		                        String s5 = inputField5.getText();
		                        String [] spString2 = s5.split("\\s+");
		                        F2=spString2;
		                        a.setF(F2);
						
								
				            // �ж��������Ϣ�Ƿ�Ϊ��
								if (s5 != null && !s5.trim().equals("")) {
				                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
									chatContent.append("������Ϣ����Ϊ:");
										for(int i=0;i<F2.length;i++) {
											chatContent.append(F2[i]+"  ");
										}																										
								    } else {
				                    // ���Ϊ�գ���ʾ�������ݲ���Ϊ��
									chatContent.append("�������ݲ���Ϊ��" + "\n");
								}
								
								//����һ������,�ӹ��췽�����洫ֵ								
								 first();
   					             
   					        //������̨���
   								try {
   									ConsoleTextArea1 c=new ConsoleTextArea1();
   									c.test();
   								} catch (IOException e1) {
   									// TODO Auto-generated catch block
   									e1.printStackTrace();
   								}
		
//								inputField1.setText("");      // ��������ı���������Ϊ��
							}
						});
//							
//			
//			Label label = new Label("�����ı���Ϣ"); // ����һ����ǩ
//			inputPanel.add(label);                // ����ǩ��ӵ�JPanel���
						
			inputPanel.add(inputField1);          // ���ı�����ӵ�JPanel���
			inputPanel.add(sendBt1);              // ����ť��ӵ�JPanel���
			inputPanel.add(inputField2);          // ���ı�����ӵ�JPanel���
			inputPanel.add(sendBt2);              // ����ť��ӵ�JPanel���
			inputPanel.add(inputField3);          // ���ı�����ӵ�JPanel���
			inputPanel.add(sendBt3);              // ����ť��ӵ�JPanel���
			inputPanel.add(inputField4);          // ���ı�����ӵ�JPanel���
			inputPanel.add(sendBt4);              // ����ť��ӵ�JPanel���
			inputPanel.add(inputField5);          // ���ı�����ӵ�JPanel���
			inputPanel.add(sendBt5);              // ����ť��ӵ�JPanel���
			
			// ����������JPanel�����ӵ�JFrame����
			this.add(showPanel, BorderLayout.CENTER);
			this.add(inputPanel, BorderLayout.SOUTH);
			this.setTitle("�ύ�ı���Ϣ");
			this.setSize(1200, 600);
			this.addWindowListener(new FirstWindowListener2());
			this.setVisible(true);
		}	
		
		
		public void first() {
			a.test1();
		}
	}