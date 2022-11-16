import java.util.*;
class HuffmanNode
{
	int data;
	char c;
	HuffmanNode left;
	HuffmanNode right;

}
class MyComparator implements Comparator<HuffmanNode>
{
	public int compare(HuffmanNode x,HuffmanNode y)
	{
		return x.data-y.data;
	}
}
public class pro2
{	public static void printCode(HuffmanNode root,String s)
	{
		if(root.left==null && root.right==null && Character.isLetter(root.c))
		{
			System.out.println(root.c+" "+s);
			return;
		}
		printCode(root.left,s+"0");
		printCode(root.right,s+"1");
	}
	public static void main(String args[])
	{
		int n=6;
		char[] charArray={'a','b','c','d','e','f'};
		int[] freq={5,3,7,8,2,9};
		PriorityQueue<HuffmanNode> p=new PriorityQueue<HuffmanNode>(n,new MyComparator());
		for(int i=0;i<n;i++)
		{
			HuffmanNode obj=new HuffmanNode();
			obj.data=freq[i];
			obj.c=charArray[i];
			obj.left=null;
			obj.right=null;
			p.add(obj);
		}
		HuffmanNode root=null;
		while(p.size()>1)	
		{
			HuffmanNode x=p.peek();
			p.poll();
			HuffmanNode y=p.peek();
			p.poll();
			HuffmanNode z=new HuffmanNode();
			z.data=x.data+y.data;
			z.c='-';
			z.left=x;
			z.right=y;
			root=z;
			p.add(z);
		}
		printCode(root," ");
	}
}
