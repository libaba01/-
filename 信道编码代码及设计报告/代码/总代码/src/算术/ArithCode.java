package ����;
import java.util.*;
public class ArithCode {
//    public static void main(String[] args) {
//        ArithCode a=new ArithCode();
//        a.setF(args);
//        a.test1();
//    }

    public int n;
    float []py=new float[n];//ԭ���ķ��Ÿ���(10����,��ͬ)
    String []NQ=new String[n+1];//�ź�˳��ǰ��������
    public int m;
    String []F=new String[10+1];//����������У�������������10��

    public void setN(int n) {
        this.n = n;
    }

    public void setPy(float[] py) {
        this.py = py;
    }

    public void setNQ(String[] NQ) {
        this.NQ = NQ;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setF(String[] f) {
        F = f;
    }

 


    public ArithCode(){
//        Scanner input=new Scanner(System.in);
//        System.out.print("�������������");
//        int i,j;

//        int n=input.nextInt();



    }


    public void test1(){
    	   float []pc=new float[n];//ԭ���ķ��Ÿ���
    	    float []pp=new float[n];//�źú�ķ��Ÿ���

    	    float []P=new float[n];
    	    String []NH=new String[n+1];//�ź�˳����������

    	    float []A=new float[10];
    	    float []C=new float[10];
    	    char []N=new char[100];
    	            float v;
        for(int i=0;i<n;i++){
//            System.out.print("��������ţ�");
////            NQ[i]=input.next();
//            System.out.print("������˷��Ŷ�Ӧ�ķ��Ÿ��ʣ�");
////            py[i]=input.nextFloat();
            float count=0;
            for(int j=0;j<=i;j++){
                count+=py[j];
            }
            if(py[i]>1||count>1){
                System.out.println("����������������룡");
                i--;
            }
        }
        for(int i=0;i<n;i++){
            pc[i]=py[i];
        }
        Arrays.sort(py);
        System.out.print("�����ķ��Ÿ��ʣ�");
        for(int i=0;i<n;i++){
            pp[i]=py[n-i-1];
            System.out.print("\t"+pp[i]);
        }
        System.out.println();
        System.out.print("�����ķ������У�");
        for(int i=0;i<n;i++){
            out:{for( int j=0;j<n;j++){
                if(pp[i]==pc[j]){
                    NH[i]=NQ[j];
                    pc[j]=0;
                    break out;
                }
            }
            }
            System.out.print("\t"+NH[i]);
        }
        System.out.println();
        System.out.print("���ŵ��ۼӸ���Ϊ��");
        for (int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                P[i]+=pp[j];
            }
            System.out.print("\t"+P[i]);
        }
        System.out.println();
        System.out.print("������������г��ȣ�");
//        int m=input.nextInt();
        System.out.print("��������Ϣ���У�"+"\n");
        
        for (int i=0;i<m;i++){
//            F[i]=input.next();
        }
        C[0]=0;A[0]=1;
        for (int i=1;i<m+1;i++){
            for(int j=0;j<n;j++){
                if(F[i-1].equals(NH[j]))
                {
                    C[i]=C[i-1]+A[i-1]*P[j];
                    A[i]=A[i-1]*pp[j];
                    System.out.print("\t\t"+"C["+i+"]="+C[i]);
                    System.out.print("\t\t"+"A["+i+"]="+A[i]);
                    System.out.println();
                }
            }
        }
        int w=(int)Math.ceil(-Math.log((double)A[m])/Math.log((double)2));
        System.out.print("�볤Ϊ��"+w);
        System.out.println();
        System.out.print("����Ϊ��            ");
        for(int i=0;i<w;i++){
            v=C[m]*2;
            if(v>=1){
                N[i]='1';
                C[m]=v-1;
            }
            else {N[i]='0';
                C[m]=v;
            }
            System.out.print("\t"+N[i]);
        }
    }

	public int getN() {
		return n;
	}

	public float[] getPy() {
		return py;
	}

	public String[] getNQ() {
		return NQ;
	}

	public int getM() {
		return m;
	}

	public String[] getF() {
		return F;
	}
}