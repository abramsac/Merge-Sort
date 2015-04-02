import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Merge_Sort3 {
	
	public static List<Integer> mergeSort(List<Integer> list){ //non-recursive mergesort
		int i = 0;
		int j = 1;//individual partition number, begins with 1 since this is bottom up mergesort
		int k = 2;//k is the total number of numbers in a comparison, begins at 2 since you compare 2 lists of size 1
		while (j < list.size()){
			while (i < list.size()){
				List<Integer> list1 = new LinkedList<Integer>();
				List<Integer> list2 = new LinkedList<Integer>();
				/*
				 * begin with individual numbers and compare them iteratively
				 * begin with index 0 and 1 and compare them and merge them in the list
				 * then move on to 2 and 3...
				 * The size of the comparisons gets bigger as j rises in the while loop...
				 * Using this method, each call in the recursive mergesort is basically done within the 
				 * actual list using iteration and the small partitions eventually build together into the 
				 * final list, although each merge call is not creating a new list and joining the lists together,
				 * it is instead altering the actual list.
				 */
				for (int x = i; x < j + i; x++){
					list1.add(list.get(x));
				}
				i = i + j;
				for (int x = i; x < j + i ; x++){
					list2.add(list.get(x));
				}
				i = i + j;
				merge(list1, list2, list, i - k);
			}
			k = k * 2; //double j and k to allow for the next level of list sizes
			j = j * 2; 
			i = 0; //return back to index 0 for larger comparisons
		}
		return list;
	}
	
	public static int compare(int one, int two){
		if (one > two){
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public static List<Integer> merge(List<Integer> list1, List<Integer> list2, List<Integer> fulllist, int index){
		/*
		 * Same merge function as in previous questions, except the function alters that actual list that was used
		 * as input into mergesort()
		 * Index is used as the place where the "merging" will begin
		 */
		
		int i = 0;
		//same algorithm except you just add the numbers right to the list instead of making a
		//temporary list
		while (list1.size() > 0 || list2.size() > 0){
			if (list1.size() > 0 && list2.size() > 0){
				if (list1.get(0) <= list2.get(0)){
					fulllist.set(i + index, list1.get(0)); 
					list1.remove(0);
					i++;
				}
				else{
					fulllist.set(i + index, list2.get(0));
					list2.remove(0);
					i++;
				}
			}
			else if (list1.size() > 0){
				fulllist.set(i + index, list1.get(0));
				list1.remove(0);
				i++;
			}
			else if (list2.size() > 0){
				fulllist.set(i + index, list2.get(0));
				list2.remove(0);
				i++;
			}
		}
		return fulllist;
	}
	
	public static void main(String[] args){
		List<Integer> test = new LinkedList<Integer>();
		Random generator = new Random();
		for (int i = 0; i < 8; i++){
			test.add(generator.nextInt(10));
		}
		/*for (int i = 100; i > 0; i--){
			test.add(i);
		}*/
		printer(test);
		test = mergeSort(test);
		printer(test);
	}
	
	public static void printer(List<Integer> list){
		for (int i = 0; i < list.size(); i++){
			System.out.print(list.get(i));
			System.out.print(" ");
		}
		System.out.println("");
	}
}
