import java.util.*;
class Fractional_Knapsack__Greedy1
{
	public static double getMax(Item[] arr,int capacity)
	{
		//sort by v/w ratio.
		Arrays.sort(arr,new Comparator<Item>()
		{
			public int compare(Item a,Item b)	
			{
				double val1=(double)(a.value/a.weight);
				double val2=(double)(b.value/b.weight);
				
				if(val1<val2)
				return 1;
				else
				return -1;
			}
		});

		
		double MaxProfit=0d;
		for(Item i:arr)
		{
			int curwt=(int)i.weight;
			int curval=(int)i.value;
			if(capacity-curwt >=0)
			{
				capacity=capacity-curwt;
				MaxProfit=MaxProfit+curval;
			}
			else
			{
				double fract=((double)capacity/(double)curwt);
				MaxProfit +=(curval*fract);
				capacity=(int)(capacity-(curwt*fract));
				break;
			}
		}
		return MaxProfit;
	}

	static class Item
	{
		int value,weight;
		public Item(int val,int wt)	
		{
			value=val;
			weight=wt;
		}
	}
	
	public static void main(String args[])
	{	Scanner sc=new Scanner(System.in);
		int capacity=50;
		Item[] arr = { new Item(60, 10),
                            new Item(100, 20),
                            new Item(120, 30) };

		Item[] objArr=new Item[3];
		for(int i=0;i<3;i++)
		{
			objArr[i]=new Item(sc.nextInt(),sc.nextInt());
		}

		 double maxValue = getMax(objArr, capacity);
 
        	// Function call
	        System.out.println(maxValue);
	}

}