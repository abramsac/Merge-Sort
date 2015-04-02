import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Merge_Sort {
	
	public static List<Integer> mergeSort(List<Integer> list1){
		if (list1.size() == 1){ //Once list is just one integer, it can be merged
			return list1;
		}
		
		else{
			List<Integer> left = new LinkedList<Integer>(); //Create left and right list around the mid number
			List<Integer> right = new LinkedList<Integer>();
			int mid = list1.size()/2;
			for (int i = 0; i < mid; i++){
				left.add(list1.get(i));
			}
			for (int i = mid; i < list1.size(); i++){
				right.add(list1.get(i));
			}
			if (left.size() > 0){ 
				printer(left);
				}
			left = mergeSort(left); //run mergesort recursively on the left list
			if (right.size() > 0){
				printer(right);
				}
			right = mergeSort(right); //run mergesort recursively on the left list
			
			return merge(left, right); //end the recursive runs and join all of the partitions together
		}
	}
	
	public static List<Integer> merge(List<Integer> list1, List<Integer> list2){ //actual merging function
		List<Integer> finallist = new LinkedList<Integer>(); 
		while (list1.size() > 0 || list2.size() > 0){ //while left and right lists still have ints in them
			if (list1.size() > 0 && list2.size() > 0){ //both lists still are not empty
				if (list1.get(0) <= list2.get(0)){ //index 0 of list 1 goes into finallist over index 0 of list2
					finallist.add(list1.get(0));
					list1.remove(0); //take out of list
				}
				else{
					finallist.add(list2.get(0)); //index 0 of list 2 goes into finallist over index 0 of list1
					list2.remove(0);
				}
			}
			else if (list1.size() > 0){ //fill finallist with list 1 because list 2 is out of numbers
				finallist.add(list1.get(0));
				list1.remove(0);
			}
			else if (list2.size() > 0){ //fill finallist with list 2 because list 1 is out of numbers
				finallist.add(list2.get(0));
				list2.remove(0);
			}
		}
		return finallist;
	}
	
	public static void main(String[] args){
		List<Integer> test = new LinkedList<Integer>();
		Random generator = new Random();
		/*for (int i = 0; i < 4; i++){ //generate random numbers for list for testing purposes
			test.add(generator.nextInt(10));
		}*/
		for (int i = 100; i > 0; i--){ //create list from 100 -> 1 for testing of merge sort
			test.add(i);
		}
		printer(test);
		test = mergeSort(test);
		printer(test);
	}
	
	public static void printer(List<Integer> list){ // list printer
		for (int i = 0; i < list.size(); i++){
			System.out.print(list.get(i));
			System.out.print(" ");
		}
		System.out.println("");
	}
	
}
