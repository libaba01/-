import java.util.*;
public class ArithCode {
   public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	System.out.print("�������������");
	int i,j;
	float v;
	int n=input.nextInt();
	float []py=new float[n];//ԭ���ķ��Ÿ���(10����,��ͬ)
	float []pc=new float[n];//ԭ���ķ��Ÿ���
	float []pp=new float[n];//�źú�ķ��Ÿ���
	String []NQ=new String[n+1];//�ź�˳��ǰ��������
	float []P=new float[n];
	String []NH=new String[n+1];//�ź�˳����������
	String []F=new String[10+1];//����������У�������������10��
	float []A=new float[10];
	float []C=new float[10];
	char []N=new char[10];
	for(i=0;i<n;i++){
		System.out.print("��������ţ�");
		NQ[i]=input.next();
		System.out.print("������˷��Ŷ�Ӧ�ķ��Ÿ��ʣ�");
		py[i]=input.nextFloat();
		float count=0;
		for(j=0;j<=i;j++){
		count+=py[j];
		}
		if(py[i]>1||count>1){
			System.out.println("����������������룡");
			i--;
		}
	 }
	for(i=0;i<n;i++){
		pc[i]=py[i];
	}
	Arrays.sort(py);
	System.out.print("�����ķ��Ÿ��ʣ�");
	for(i=0;i<n;i++){
		pp[i]=py[n-i-1];
		System.out.print("\t"+pp[i]);
	}
	System.out.println();
	System.out.print("�����ķ������У�");
	for(i=0;i<n;i++){
		out:{for( j=0;j<n;j++){	
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
	for (i=0;i<n;i++){
	    for(j=0;j<i;j++){
		P[i]+=pp[j];
	}
	System.out.print("\t"+P[i]);
	}
	System.out.println();
	System.out.print("������������г��ȣ�");
	int m=input.nextInt();
	System.out.print("��������Ϣ���У�");
	for (i=0;i<m;i++){
		F[i]=input.next();
	}
	C[0]=0;A[0]=1;
	for (i=1;i<m+1;i++){
	   for( j=0;j<n;j++){
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
	for( i=0;i<w;i++){
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
}
