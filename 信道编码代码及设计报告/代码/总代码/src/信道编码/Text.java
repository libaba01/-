package �ŵ�����;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import LZW.Compress;
import LZW.Uncompress;

public class Text {
	public static void main(String[] args) {
        new text1();
	}
}

class text1 extends Frame{
	public text1() {
		//Frame���
		Frame frame=new Frame("�ı�ѹ��");
	//Panel����
        Panel p1 = new Panel(new GridLayout(4, 2,20,10));//3��2�� ˮƽ���20 ��ֱ���10
      //��һ��
        Label label1=new Label("�ı�ѹ��",Label.CENTER);
		p1.add(label1);
		

		//�ڶ���
		Label label2=new Label("��ѡ��ѹ���㷨",Label.CENTER);
		p1.add(label2);
		
		//������
		Button but1 = new Button("��ŵ");
        Button but2 = new Button("��ũ");
        but1.setBackground(Color.blue);
        
        but2.setBackground(Color.yellow);

		p1.add(but1);
		p1.add(but2);
		
		//������
		Button but3 = new Button("����");
        Button but4 = new Button("LZW");
        but3.setBackground(Color.blue);
        
        but4.setBackground(Color.yellow);

		p1.add(but3);
		p1.add(but4);
		
		
		
		
		//Ϊÿ����ť�����굥������¼�
		
		//��ŵ
				but1.addMouseListener(new MouseListener() {
					
					@Override
					//��갴��
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						//������
						if(e.getButton()==e.BUTTON1){
							//�������ť
							new fetch_test2 ();
						}	
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		
		//��ũ
		but2.addMouseListener(new MouseListener() {
			
			@Override
			//��갴��
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//������
				if(e.getButton()==e.BUTTON1){
					//�������ť
					new fetch_test1 ();
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//����
		but3.addMouseListener(new MouseListener() {
			
			@Override
			//��갴��
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//������
				if(e.getButton()==e.BUTTON1){
					//�������ť
					new fetch_test4 ();
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//LZW
				but4.addMouseListener(new MouseListener() {
					
					@Override
					//��갴��
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						//������
						if(e.getButton()==e.BUTTON1){
							//�������ť
							
							new LZWGUI();
							Compress com = new Compress();
							Uncompress ucom = new Uncompress();
							
							File file1 = new File("data1.txt"); //��ѹ�����ļ�
							File file2 = new File("data2.txt"); //ѹ�������ļ�
							File file3 = new File("data3.txt"); //��ѹĿ¼�ļ�
							
							com.compress(file1,file2); //�ļ�ѹ���ķ���
							try {
								ucom.uncompress(file2, file3);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}//�ļ���ѹ����
						}	
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
				
				
		
		
		

		frame.setBounds(100, 100, 400, 300);
        frame.setLayout(new FlowLayout()); //���ò��ֹ�����ΪFlowLayout
        frame.setVisible(true);
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,20,40); //���뷽ʽ�����󣬺�����20���أ�������40���أ�
        frame.setLayout(fl);
        frame.add(p1);   
        //���ڹر�
        frame.addWindowListener(new FirstWindowListener2());
	}
	
}

//�¼���������̳���������
class FirstWindowListener2 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}
