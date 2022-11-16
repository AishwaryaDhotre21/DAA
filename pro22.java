import java.util.*;
class huffmanNode
{
	int data;
	char c;
	huffmanNode left;
	huffmanNode right;
}
class MyComparator implements Comparator<huffmanNode>
{
	public int compare(huffmanNode x,huffmanNode y)
	{
		return x.data-y.data;
	}
}
class pro22
{
	public static void printCode(huffmanNode root,String s)
	{
		if(root.left==null && root.right==null && Character.isLetter(root.c))
		{
			System.out.println(root.c+" : "+s);
			return;
		}
		printCode(root.left,s+"0");
		printCode(root.right,s+"1");
	}
	public static void main(String args[])
	{
		int n=6;
		char[] letter=new char[6];
		int[] freq=new int[6];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<n;i++)
		{
			letter[i]=sc.next().charAt(0);
		}
		for(int j=0;j<n;j++)
		{
			freq[j]=sc.nextInt();
		}
		PriorityQueue<huffmanNode> q=new PriorityQueue<huffmanNode>(n,new MyComparator());
		for(int k=0;k<n;k++)
		{
			huffmanNode obj=new huffmanNode();
			obj.data=freq[k];
			obj.c=letter[k];
			obj.left=null;
			obj.right=null;
			q.add(obj);
		}
		huffmanNode root=null;
		while(q.size()>1)
		{
			huffmanNode x=q.peek();
			q.poll();
			huffmanNode y=q.peek();
			q.poll();
			huffmanNode z=new huffmanNode();
			z.data=x.data+y.data;
			z.c='-';
			z.left=x;
			z.right=y;
			root=z;
			q.add(z);
		}
		printCode(root,"");
	}
}