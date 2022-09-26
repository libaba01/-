package ����;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

import LZW.Uncompress;
import �ŵ�����.fetch_test4;
public class ConsoleTextArea1 extends JTextArea {
    public ConsoleTextArea1(InputStream[] inStreams) {
        for(int i = 0; i < inStreams.length; ++i)
            startConsoleReaderThread(inStreams[i]);
    } // ConsoleTextArea()
    public ConsoleTextArea1() throws IOException {
        final LoopedStreams ls = new LoopedStreams();
        // �ض���System.out��System.err
        PrintStream ps = new PrintStream(ls.getOutputStream());
        System.setOut(ps);
        System.setErr(ps);
        startConsoleReaderThread(ls.getInputStream());
    } // ConsoleTextArea()
    private void startConsoleReaderThread(
        InputStream inStream) {
        final BufferedReader br =
            new BufferedReader(new InputStreamReader(inStream));
        new Thread(new Runnable() {
            public void run() {
                StringBuffer sb = new StringBuffer();
                try {
                    String s;
                    Document doc = getDocument();
                    while((s = br.readLine()) != null) {
                        boolean caretAtEnd = false;
                        caretAtEnd = getCaretPosition() == doc.getLength() ?
                            true : false;
                        sb.setLength(0);
                        append(sb.append(s).append('\n').toString());
                        if(caretAtEnd)
                            setCaretPosition(doc.getLength());
                    }
                }
                catch(IOException e) {
                    JOptionPane.showMessageDialog(null,
                        "��BufferedReader��ȡ����" + e);
                    System.exit(1);
                }
            }
        }).start();
    } // startConsoleReaderThread()
    // ����ʣ�ಿ�ֵĹ����ǽ��в���
    
    public void test() throws IOException {
    	
    	JFrame f = new JFrame("ConsoleTextArea����");
        ConsoleTextArea1 consoleTextArea = null;
        try {
            consoleTextArea = new ConsoleTextArea1();
        }
        catch(IOException e) {
            System.err.println(
                "���ܴ���LoopedStreams��" + e);
            System.exit(1);
        }
        consoleTextArea.setFont(java.awt.Font.decode("monospaced"));
        f.getContentPane().add(new JScrollPane(consoleTextArea),
            java.awt.BorderLayout.CENTER);
        f.setBounds(50, 50, 600, 500);
        f.setVisible(true);
        f.addWindowListener(new FirstWindowListener2());
        //���Ҫչʾ�ķ���
        
        fetch_test4 f1=new fetch_test4();
        f1.first();
        
    }
    
//    public static void main(String[] args) throws IOException {
//        
//		
//        
//        
//    } // main()
    private static void startWriterTestThread(
        final String name, final PrintStream ps, 
        final int delay, final int count) {
        new Thread(new Runnable() {
            public void run() {
                for(int i = 1; i <= count; ++i) {
                    ps.println("***" + name + ", hello !, i=" + i);
                    try {
                        Thread.sleep(delay);
                    }
                    catch(InterruptedException e) {}
                }
            }
        }).start();
    } // startWriterTestThread()
} // ConsoleTextArea

//�¼���������̳���������
class FirstWindowListener2 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}

