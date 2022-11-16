import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ItemValue {
	
	int value;
	int weight;
	double unitValue;
	
	ItemValue(int value, int weight) {
		this.value = value;
		this.weight = weight;
		this.unitValue = (double) value / (double) weight;
	}
	
}

public class knapsackProblem_greedy {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
		double maxValue = 0;
		
        int N = sc.nextInt();
		int W = sc.nextInt();
		ItemValue[] arr = new ItemValue[N];
        
		for(int i = 0; i < N; i++) {
			
            arr[i] = new ItemValue(sc.nextInt(), sc.nextInt());
			
		}
        
        Arrays.sort(arr, new Comparator<ItemValue>() {
        	
        	@Override
        	public int compare(ItemValue o1, ItemValue o2) {
        		return (int) (o2.unitValue - o1.unitValue);
        	}
        	
        });

        for(ItemValue item : arr) {
        	System.out.println(item.unitValue);
        }
        
        for(ItemValue item : arr) {
        	
        	if(item.weight < W) {
        		maxValue += item.value;
        		W -= item.weight;
        	} else {
        		//Multiplying unit cost with the available space/ capacity/ W.
        		maxValue += (W * item.unitValue);
        		W = 0;
        		break;
        	}

        }
        System.out.format("%.6f", maxValue);
	}

}
