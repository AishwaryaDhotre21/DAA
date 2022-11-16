import java.util.*;
class Item
{
	int profit;
	int weight;
	double vw;
	
	Item(int p,int w)
	{
		profit=p;
		weight=w;
		this.vw=(double)p/(double)w;
	}
}
class MyComparator implements Comparator<Item>
{
	public int compare(Item a,Item b)
	{
		return(int) (a.vw-b.vw);
	}
}
public class Knapsack_greedy
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		double maxProfit=0;
		int ItemCount=sc.nextInt();
		int BagWeight=sc.nextInt();
		Item[] objArr=new Item[ItemCount];
		for(int i=0;i<ItemCount;i++)
		{
			objArr[i]=new Item(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(objArr,new MyComparator());
		for(Item i:objArr)
		{
			System.out.println(i.vw);
		}
		for(Item i:objArr)
		{
			if(i.weight < BagWeight)
			{
				maxProfit=i.profit+maxProfit;
				BagWeight=BagWeight-i.weight;
			}
			else
			{
				maxProfit += (BagWeight*i.vw);
				BagWeight=0;
				break;
			}
		}
		System.out.format("%.6f", maxProfit);
	}
}