package �ŵ�����;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;

import LZW.Compress;
import LZW.Uncompress;
import LZW.lzw;
import lib.ConsoleTextArea;
import ��ŵ.Test;
import ��ŵ.list;

class LZWGUI {
    private Frame f;// ���崰��
    private MenuBar bar;// ����˵���
    private TextArea ta;
    private Menu fileMenu;// ����"�ļ�"��"�Ӳ˵�"�˵�
    private MenuItem openItem, saveItem, closeItem;// ������Ŀ���˳����͡�����Ŀ���˵���

    private FileDialog openDia, saveDia;// ���塰�򿪡����桱�Ի���
    private File file;//�����ļ�

    LZWGUI() {
        init();
    }

    /* ͼ���û����������ʼ�� */
    public void init() {
        f = new Frame("LZW");// �����������
        f.setBounds(300, 100, 650, 600);// ���ô���λ�úʹ�С

        bar = new MenuBar();// �����˵���
        ta = new TextArea();// �����ı���

        fileMenu = new Menu("�ļ�");// �������ļ����˵�

        openItem = new MenuItem("��");// ��������"�˵���
        saveItem = new MenuItem("����");// ����������"�˵���
        closeItem = new MenuItem("�˳�");// �������˳�"�˵���

        fileMenu.add(openItem);// �����򿪡��˵�����ӵ����ļ����˵���
        fileMenu.add(saveItem);// �������桱�˵�����ӵ����ļ����˵���
        fileMenu.add(closeItem);// �����˳����˵�����ӵ����ļ����˵���

        bar.add(fileMenu);// ���ļ���ӵ��˵�����

        f.setMenuBar(bar);// ���˴���Ĳ˵�������Ϊָ���Ĳ˵�����

        openDia = new FileDialog(f, "��", FileDialog.LOAD);
        saveDia = new FileDialog(f, "����", FileDialog.SAVE);

        f.add(ta,BorderLayout.CENTER);// ���ı�����ӵ�������
        
        Panel p = new Panel();
        //��Ӱ�ť
        JButton sendBt1 = new JButton("����");      // ����һ����ť

        
        JButton sendBt2 = new JButton("����");      // ����һ����ť

        
        p.add(sendBt1,"BorderLayout.WEST");
        p.add(sendBt2,"BorderLayout.EAST");
                f.add(p,BorderLayout.SOUTH);
        myEvent();// �����¼�����

        

		
		// Ϊ��ť����¼�
		sendBt1.addActionListener(new ActionListener() { 
			// Ϊ��ť���һ�������¼�e
			public void actionPerformed(ActionEvent e) {
				Compress com = new Compress();
				//���ļ���·��������
				String dirpath1 = openDia.getDirectory();
				String fileName = openDia.getFile();
				
				File file1 = new File(dirpath1+fileName); //��ѹ�����ļ�
				File file2 = new File("data2.txt"); //ѹ�������ļ�
				
				lzw l=com.compress(file1,file2);
				 //�ļ�ѹ���ķ���
				//��ѹ���Ĺ���չʾ���ı�����
				
				ta.append("�ϳ��ַ�����"+"\n");
				Iterator<Object> iter1 = l.getList1().iterator();
			     while (iter1.hasNext()) {
			            String s = (String) iter1.next();
			            ta.append(s+"   ");
			            }
			     ta.append("\n");
			     ta.append("��Ӧ���룺 "+"\n");
					Iterator<Object> iter2 = l.getList2().iterator();
				     while (iter2.hasNext()) {
				            String s = (String) iter2.next();
				            ta.append(s+"   ");
				            }
				     ta.append("\n");
				     
				     
				     ta.append("д���ǰ׺�� "+"\n");
						Iterator<Object> iter3 = l.getList3().iterator();
					     while (iter3.hasNext()) {
					            String s = (String) iter3.next();
					            ta.append(s+"   ");
					            }  
					     ta.append("\n");
					     
					     
					  ta.append("���ı��룺 "+"\n");
							Iterator<Object> iter4 = l.getList4().iterator();
						     while (iter4.hasNext()) {
						            String s = (String) iter4.next();
						            ta.append(s+"   ");
						            }			     
						     ta.append("\n");
						     
						     
					  ta.append("�����ַ��� "+"\n");
								Iterator<Object> iter5 = l.getList5().iterator();
							     while (iter5.hasNext()) {
							            String s = (String) iter5.next();
							            ta.append(s+"   "+"\n");
							            }
					  ta.append("д��ı��룺 "+"\n");
									Iterator<Object> iter6 = l.getList6().iterator();
								     while (iter6.hasNext()) {
								            String s = (String) iter6.next();
								            ta.append(s+"   "+"\n");
								            }
						     
						     
						     
//				for(Entry<Object, Object> arg : l.getFirst().entrySet()){	
//					ta.append("�ϳ��ַ�����"+arg.getKey()+"\n");
//					ta.append("��Ӧ���룺"+arg.getValue()+"\n");
//				}
//				
//				for(Entry<Object, Object> arg : l.getSecond().entrySet()){	
//					ta.append("д���ǰ׺��"+arg.getKey()+"\n");
//					ta.append("���ı��룺"+arg.getValue()+"\n");
//				}
//				
//				
//				for(Entry<Object, Object> arg : l.getSecond().entrySet()){	
//					ta.append("�����ַ���"+arg.getKey()+"\n");
//					ta.append("д��ı��룺"+arg.getValue()+"\n");
//				}
				
				
				
				
				
//				String content = inputField.getText();

				// �ж��������Ϣ�Ƿ�Ϊ��
//				if (content != null && !content.trim().equals("")) {
//                     // �����Ϊ�գ���������ı�׷�ӵ������촰��
//					//���ı��������������
////				
////					ta.append("�ַ������ȣ�"+l1.getLength()+"\n");
////					ta.append("��:"+l1.getSum()+"\n"); 
////					ta.append("ƽ���볤:"+l1.getAver()+"\n"); 
////					ta.append("����Ч��:"+l1.getEffiency()+"\n"); 
//				}
			}
		});
		
		
		sendBt2.addActionListener(new ActionListener() { 
			// Ϊ��ť���һ�������¼�e
			public void actionPerformed(ActionEvent e) {
				Uncompress ucom = new Uncompress();
				
                String dirpath2 = openDia.getDirectory();
                String fileName = openDia.getFile();
                
				File file2 = new File(dirpath2+fileName); //Ҫ��ѹ�����ļ�
				File file3 = new File("data3.txt"); //��ѹ��Ŀ¼�ļ�
				try {
					ucom.uncompress(file2, file3);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//�ļ���ѹ����
				
				//����ѹ�Ĺ���չʾ��һ��������
				try {
					ConsoleTextArea c=new ConsoleTextArea();
					c.test();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
        f.setVisible(true);// ���ô���ɼ�

    }

    private void myEvent() {
        
        // �򿪲˵������
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                openDia.setVisible(true);//��ʾ���ļ��Ի���
                
                String dirpath = openDia.getDirectory();//��ȡ���ļ�·�������浽�ַ����С�
                String fileName = openDia.getFile();//��ȡ���ļ����Ʋ����浽�ַ�����
                
                if (dirpath == null || fileName == null)//�ж�·�����ļ��Ƿ�Ϊ��
                    return;
                else
                    ta.setText(null);//�ļ���Ϊ�գ����ԭ���ļ����ݡ�
                file = new File(dirpath, fileName);//�����µ�·��������

                try {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));//���Դ��ļ��ж�����
                    String line = null;//�����ַ�����ʼ��Ϊ��
                    while ((line = bufr.readLine()) != null) {
                        ta.append(line + "\r\n");//��ʾÿһ������
                    }
                    bufr.close();//�ر��ļ�
                } catch (FileNotFoundException e1) {
                    // �׳��ļ�·���Ҳ����쳣
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // �׳�IO�쳣
                    e1.printStackTrace();
                }

            }

        });
        
        // ����˵������
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    saveDia.setVisible(true);//��ʾ�����ļ��Ի���
                    String dirpath = saveDia.getDirectory();//��ȡ�����ļ�·�������浽�ַ����С�
                    String fileName = saveDia.getFile();////��ȡ�򱣴��ļ����Ʋ����浽�ַ�����
                    
                    if (dirpath == null || fileName == null)//�ж�·�����ļ��Ƿ�Ϊ��
                        return;//�ղ���
                    else
                        file=new File(dirpath,fileName);//�ļ���Ϊ�գ��½�һ��·��������
                }
                    try {
                        BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                        
                        String text = ta.getText();//��ȡ�ı�����
                        bufw.write(text);//����ȡ�ı�����д�뵽�ַ������
                        
                        bufw.close();//�ر��ļ�
                    } catch (IOException e1) {
                        //�׳�IO�쳣
                        e1.printStackTrace();
                    }
                

            }

        });
        
        // �˳��˵������
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        
        // ����رռ���
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	Window window = (Window) e.getComponent();
        		window.dispose();

            }

        });
    }

    public static void main(String[] args) {
        new LZWGUI();
    }
}