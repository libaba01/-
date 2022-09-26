package �ŵ�����;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.*;

import ��ũ.ShannonEncoding;



//1.�ӵ�ǰ�����ı����л�ȡ�ı���Ϣ������
//2.�����������н��������ǰ���ı�����


public class fetch_text{
	public static void main(String[] args) {
	new fetch_test1 ();
 }
}

class fetch_test1 extends JFrame {
	
	//һ�������ı���һ���ı�����ʾ�������Ϣ
		JButton sendBt;
		JTextField inputField;
		JTextArea chatContent;

		public fetch_test1() {
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
					
					//��ȡ������ı���Ϣ֮�󣬽�����ũ����
					ShannonEncoding shannonEncoding = new ShannonEncoding(content);
			        shannonEncoding.getProbability();
			        HashMap<String, String> map1=shannonEncoding.codeLetter();
			        
					
					
	            // �ж��������Ϣ�Ƿ�Ϊ��
					if (content != null && !content.trim().equals("")) {
	                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
						//���ı��������ƽ���볤�ͱ���Ч��
					
						
						for(Entry<String, String> arg : map1.entrySet()){				//����HashMap��ֵ��
							chatContent.append(arg.getKey()+"����"+arg.getValue()+"\n");
							
						}
						chatContent.append("ƽ���볤:"+shannonEncoding.averageCodingLength() + "\n"+"����Ч��:"+shannonEncoding.codeEfficiency()+ "\n"); 
						
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

