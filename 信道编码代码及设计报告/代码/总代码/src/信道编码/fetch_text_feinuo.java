package �ŵ�����;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import ��ŵ.Test;
import ��ũ.ShannonEncoding;
import ��ŵ.list;


//1.�ӵ�ǰ�����ı����л�ȡ�ı���Ϣ������
//2.�����������н��������ǰ���ı�����


public class fetch_text_feinuo{
	public static void main(String[] args) {
	new fetch_test2 ();
 }
}

class fetch_test2 extends JFrame {
	
	

		public fetch_test2() {
			
			//һ�������ı���һ���ı�����ʾ�������Ϣ
			JButton sendBt;
			JTextField inputField;
			JTextArea chatContent;
			this.setLayout(new BorderLayout());
			chatContent = new JTextArea(12, 34); // ����һ���ı���
			// ����һ��������壬���ı�����Ϊ����ʾ���
			JScrollPane showPanel = new JScrollPane(chatContent);
			chatContent.setEditable(false);    // �����ı��򲻿ɱ༭
			JPanel inputPanel = new JPanel(); // ����һ��JPanel���
			inputField = new JTextField(20);  // ����һ���ı���
			sendBt = new JButton("�ύ");      // ����һ�����Ͱ�ť
			
			// Ϊ��ť����¼�
			sendBt.addActionListener(new ActionListener() { 
				// Ϊ��ť���һ�������¼�e
				public void actionPerformed(ActionEvent e) {
					// ��дactionPerformed����
					// ��ȡ������ı���Ϣ
					String content = inputField.getText();  
					
					//��ȡ������ı���Ϣ֮�󣬽��з�ŵ����
					Test t=new Test(content);
					list l1;
					l1=t.test1();					
					
	            // �ж��������Ϣ�Ƿ�Ϊ��
					if (content != null && !content.trim().equals("")) {
	                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
						//���ı��������������
					
						chatContent.append("�ַ������ȣ�"+l1.getLength()+"\n");
						chatContent.append("��:"+l1.getSum()+"\n"); 
						chatContent.append("ƽ���볤:"+l1.getAver()+"\n"); 
						chatContent.append("����Ч��:"+l1.getEffiency()+"\n"); 
					
						//����ַ����ֵĴ�������
						List<Object> gailv = new ArrayList<>();
						Map<Object, Object> zifu = new HashMap<>();
						
						gailv=l1.getGailv();
						zifu=l1.getZifu();
//						Set hashSet = new HashSet();
//						
//						List list=new ArrayList();
						
						for (int i = 0; i < gailv.size(); i++) {
							for(Entry<Object, Object> arg :zifu.entrySet()){				//����HashMap��ֵ��
								String s = (String)gailv.get(i);
								chatContent.append("�ַ�"+arg.getKey()+"���ִ���Ϊ��"+arg.getValue()+"\n");
	                            chatContent.append("    "+"����Ϊ��"+s+"\n");
							}
						}
//					if(hashSet.add(arg.getKey())) {
//						list.add(arg.getKey());
//						
//						list.add(arg.getKey());
//					}
//					
//					if(hashSet.add(arg.getValue())) {
//						list.add(arg.getValue());
//					}
//					if(hashSet.add(s)) {
//						list.add(s);
//					}
//								    	 
//						}
//						}
//                             
//						Iterator iterator = list.iterator();
//						while (iterator.hasNext()) {
//							chatContent.append("�ַ�.���ִ���.��������Ϊ��"+iterator.next()+"\n");		
//						}	
//
//						for (int i = 0; i < gailv.size(); i++) {
//							chatContent.append("�ַ�"+arg.getKey()+"���ִ���Ϊ��"+arg.getValue()+"\n");
//                            chatContent.append("    "+"����Ϊ��"+s+"\n");
//						}
//                                 

						
					    //����������
				        List<Object> list1=new ArrayList<Object>();
				        List<Object> list2=new ArrayList<Object>();
//						Map<Object, Object> mazi = new HashMap<>();
//						mazi=l1.getMazi();
  					    list1=l1.getList1();
  					  list2=l1.getList2();
  					  
  					Iterator it1 = list1.iterator();
  			        while(it1.hasNext()){
  			        	chatContent.append(it1.next()+"  ");
  			        }
                     chatContent.append("\n");
  			      Iterator it2 = list2.iterator();
			        while(it2.hasNext()){
			        	chatContent.append(it2.next()+"  ");
			        }
  					  
  					  
//						for(Entry<Object, Object> arg : mazi.entrySet()){	
//	
//							chatContent.append(arg.getKey()+"    "+arg.getValue()+"\n");
//							
//						}
//				
						
					    } else {
	                    // ���Ϊ�գ���ʾ�������ݲ���Ϊ��
						chatContent.append("�������ݲ���Ϊ��" + "\n");
					}
					inputField.setText("");      // ��������ı���������Ϊ��
				}
			});
			Label label = new Label("�����ı���Ϣ"); // ����һ����ǩ
			inputPanel.add(label);                // ����ǩ��ӵ�JPanel���
			inputPanel.add(inputField);          // ���ı�����ӵ�JPanel���
			inputPanel.add(sendBt);              // ����ť��ӵ�JPanel���
			// ����������JPanel�����ӵ�JFrame����
			this.add(showPanel, BorderLayout.CENTER);
			this.add(inputPanel, BorderLayout.SOUTH);
			this.setTitle("�ύ�ı���Ϣ");
			this.setSize(400, 300);
			this.addWindowListener(new FirstWindowListener2());
			this.setVisible(true);

		}
		
	}

