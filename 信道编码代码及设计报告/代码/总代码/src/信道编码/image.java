package �ŵ�����;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class image {
	public static void main(String[] args) {
        new image1();
	}
}



class image1 extends Frame{
	public image1() {
		//Frame���
		Frame frame=new Frame("ͼ��ѹ��");
	//Panel����
        Panel p1 = new Panel(new GridLayout(4, 2,20,10));//3��2�� ˮƽ���20 ��ֱ���10
      //��һ��
        Label label1=new Label("ͼ��ѹ��",Label.CENTER);
		p1.add(label1);
		

		//�ڶ���
		Label label2=new Label("��ѡ��ѹ���㷨",Label.CENTER);
		p1.add(label2);
		
		//������
		Button but1 = new Button("������");
        Button but2 = new Button("�γ�");
        but1.setBackground(Color.blue);
        
        but2.setBackground(Color.yellow);

		p1.add(but1);
		p1.add(but2);
		
		//Ϊÿ����ť�����굥������¼�
		
				//������
						but1.addMouseListener(new MouseListener() {
							
							@Override
							//��갴��
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								//������
								if(e.getButton()==e.BUTTON1){
									//�������ť
									new fetch_image().init();
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
						
						//�γ�
								but2.addMouseListener(new MouseListener() {
									
									@Override
									//��갴��
									public void mouseClicked(MouseEvent e) {
										// TODO Auto-generated method stub
										//������
										if(e.getButton()==e.BUTTON1){
											//�������ť
											new fetch_image_youcheng().init();
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
        frame.addWindowListener(new FirstWindowListener());
     
	}
	
}

//�¼���������̳���������
class FirstWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}
