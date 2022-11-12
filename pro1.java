import java.util.*;
class pro1
{	static int a=0,b=1;
	static void fun3(int n)
	{
		if(n>0)
		{
			int n3=a+b;
			System.out.println(n3);
			a=b;
			b=n3;
			fun3(n-1);
		}
	}
	static int fun4(int n)
	{
		if(n==0)return 0;
		if(n==1)return 1;
		return fun4(n-1)+fun4(n-2);
	}
	static void fun1(int n)
	{
		if(n==0)
		{
			System.out.println("0th = "+0);
			return;
		}
		else if(n==1)
		{
			System.out.println("0th ="+0);
			System.out.println("1st ="+1);
			return;
		}
		else
		{	int i,n1=0,n2=1,n3;
			System.out.println("0th = "+0);
			System.out.println("1st ="+1);
			for(i=2;i<=n;i++)
			{
				n3=n1+n2;
				System.out.println(i+"th = "+n3);
				n1=n2;
				n2=n3;
			}
		}
	}
	static int fun2(int n)
	{
		int n1=0,n2=1,n3=0,i;
		for(i=2;i<=n;i++)
		{
			n3=n1+n2;
			n1=n2;
			n2=n3;
		}
		return n3;
	}
	
	public static void main(String args[])
	{	Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number till you want to print the fibonacci series:");
		int n1;
		n1=sc.nextInt();
		System.out.println("Non recursive approach:");
		fun1(n1);
		int ans=fun2(n1);
		System.out.println(n1+"th pos fibonacci number:"+ans);
		System.out.println("\n\nrecursive approach:");
		if(n1==0)
		{
			
			System.out.println("0th = "+0);
		}
		else if(n1==1)
		{
			System.out.println("0th ="+0);
			System.out.println("1st ="+1);
		}
		else
		{
			System.out.println("0th ="+0);
			System.out.println("1st ="+1);
			fun3(n1-1);
		}
		ans=fun4(n1);
		System.out.println(n1+"th pos fibonacci number:"+ans);
		
	}
}