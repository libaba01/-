package �ŵ�����;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import javax.swing.JFrame;

class second extends Frame implements ActionListener{
	public second() {
		//Frame���
		Frame frame=new Frame("��ҳ");
	//Panel����
        Panel p1 = new Panel(new GridLayout(3, 2,20,10));//3��2�� ˮƽ���20 ��ֱ���10
      //��һ��
        Label label=new Label("�ŵ��������ͼ���ı�ѹ��",Label.CENTER);
		p1.add(label);
		

		//�ڶ���
        
        Button but1 = new Button("ͼ��ѹ��");
        Button but2 = new Button("�ı�ѹ��");
        but1.setBackground(Color.blue);
        
        but2.setBackground(Color.yellow);

		p1.add(but1);
		p1.add(but2);
		
		// Ϊ��ť1�������¼�������
				but1.addMouseListener(new MouseListener() {
				
					@Override
					//��갴��
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						//������
						if(e.getButton()==e.BUTTON1){
							//�������ťͼ��ѹ��,��ת��ͼ��ѹ������
							new image1();
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
		
				// Ϊ��ť2�������¼�������
				but2.addMouseListener(new MouseListener() {
				
					@Override
					//��갴��
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						//������
						if(e.getButton()==e.BUTTON1){
							//�������ť�ı�ѹ������ת���ı�ѹ������
							
							new text1();
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
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,20,40); //�������������뷽ʽ�����󣬺�����20���أ�������40���أ�
        frame.setLayout(fl);
        frame.add(p1);   
        //���ڹر�
        frame.addWindowListener(new FirstWindowListener1());
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

//�¼���������̳���������
class FirstWindowListener1 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}

public class firstpage{
	public static void main(String[] args) {
        new second();
	}
}


