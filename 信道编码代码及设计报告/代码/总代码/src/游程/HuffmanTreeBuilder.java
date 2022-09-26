package �γ�;
import java.util.*;


/**

* �������ڵ�

*/

class Node implements Comparable {

	private int value;

	private Node leftChild;

	private Node rightChild;

	public String code = "";

	public Node(int value) {

       this.value = value;

    }

    public int getValue() {

        return value;

    }

    public void setValue(int value) {

        this.value = value;

    }

    public Node getLeftChild() {

         return leftChild;

    }

    public void setLeftChild(Node leftChild) {

         this.leftChild = leftChild;

    }

    public Node getRightChild() {

         return rightChild;

    }

    public void setRightChild(Node rightChild) {

        this.rightChild = rightChild;

    }

    public int compareTo(Object o) {

       Node that = (Node) o;

       double result = this.value - that.value;

         return result > 0 ? 1 : result == 0 ? 0 : -1;

    }

    public String toString()
    {
    	return "Node:(value:" + getValue() + ",code:" + code + ")";
    }


}

/**

* �������������ࣺ

*/


public class HuffmanTreeBuilder {
/*
    public static void main(String[] args) {

        List<Node> nodes = Arrays.asList(

                 new Node(1),

                 new Node(1),

                 new Node(1),

                 new Node(1),
                 new Node(4)

        );

        Node node = HuffmanTreeBuilder.build(nodes);

        CodeTree(node);

        PrintTree(node);
}
*/

    public static void numToTree(ArrayList<Integer> numArray)
    {
    	List<Node> nodes = new ArrayList<Node>();
    	for(int getnum : numArray)
    	{
    		nodes.add(new Node(getnum));
    	}

    	Node node = HuffmanTreeBuilder.build(nodes);

        CodeTree(node);

        PrintTree(node);
    }

    public static void CodeInHaffuman(HashSet<Run_Code> CodeforCoding)
    {
    	HashSet<Run_Code> X = new HashSet<Run_Code>();
    }

/**

* �����������

* @param nodes ��㼯��

* @return ������������ĸ����

*/

   private static Node build(List<Node> nodes) {

        nodes = new ArrayList<Node>(nodes);

        sortList(nodes);

        while (nodes.size() > 1) {

             createAndReplace(nodes);

         }

        return nodes.get(0);

     }



/**

* �������Ȩֵ��С��㣬���ڽ���б��������ǵĸ�����滻����

* @param nodes ��㼯��

*/

private static void createAndReplace(List<Node> nodes) {

         Node left = nodes.get(0);

         Node right = nodes.get(1);

         Node parent = new Node(left.getValue() + right.getValue());

         parent.setLeftChild(left);

         parent.setRightChild(right);

         nodes.remove(0);

         nodes.remove(0);

         nodes.add(parent);

         sortList(nodes);

     }

/**

* ����㼯���ɴ�С����

*/

private static void sortList(List<Node> nodes) {

        Collections.sort(nodes);

    }



/**

* ��ӡ���ṹ����ʾ�ĸ�ʽ��node(left,right)

* @param node

*/

public static void PrintTree(Node node)

{

     Node left = null;

     Node right = null;

     if(node!=null)

     {

        System.out.print(node);

        left = node.getLeftChild();

         right = node.getRightChild();

         System.out.println("Its children:" + "left:" + left + ",right:" + right);

     }

     if(left!=null)

        PrintTree(left);

     if(right!=null)

        PrintTree(right);

}

	public static void CodeTree(Node node)
	{
		Node left = null;
		Node right = null;

		if(node != null)
	    {
	        left = node.getLeftChild();
	        right = node.getRightChild();

	     }
	     if(left != null)
	     {
	    	left.code = node.code.concat("0");
	    	CodeTree(left);
	     }

	     if(right != null)
	     {
	    	 right.code = node.code.concat("1");
	    	 CodeTree(right);
	     }
	}

}
