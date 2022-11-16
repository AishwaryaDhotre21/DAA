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
		vw=(double) profit/(double) weight;
	}
	
}
class MyComparator implements Comparator<Item>
{
	public int compare(Item a, Item b)
	{
		return (int) (a.vw-b.vw);
	}
}
class pro3
{
	public static void main(String args[])
	{	
		Scanner sc=new Scanner(System.in);
		double maxProfit=0;
		int BagWeight=0;
		System.out.println("Enter the max Bag Weight:");
		BagWeight=sc.nextInt();
		System.out.println("Enter the total itemcount:");
		int ItemCount=sc.nextInt();
		Item[] objArr=new Item[ItemCount];
		for(int i=0;i<ItemCount;i++)
		{
			objArr[i]=new Item(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(objArr,new MyComparator());
		System.out.println("Profit   Weight    (v/w)ratio");
		for(Item i:objArr)
		{
			System.out.println(i.profit+"   "+i.weight+"   "+i.vw );
		}
		for(Item i:objArr)	
		{
			if(i.weight<BagWeight)
			{
				BagWeight -=i.weight;
				maxProfit += i.profit;
			}
			else
			{
				maxProfit += (BagWeight*i.vw);
				BagWeight=0;
				break;
			}
		}
		System.out.print(maxProfit);
	}
}