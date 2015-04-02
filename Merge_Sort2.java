import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Merge_Sort2 {
	
	public static List<Integer> mergeSort(List<Integer> list1, int switcher){ //alternating left-right mergesort
		if (list1.size() == 1){
			return list1;
		}
		
		/* same algorithm is used, except there is a switch that alternates recursively 
		 * and alternates the recursion to go back and forth between doing the left tree
		 * and right tree first
		 */
		
		else{
			List<Integer> left = new LinkedList<Integer>();
			List<Integer> right = new LinkedList<Integer>();
			int mid = list1.size()/2;
			for (int i = 0; i < mid; i++){
				left.add(list1.get(i));
			}
			for (int i = mid; i < list1.size(); i++){
				right.add(list1.get(i));
			}
			if (switcher == 0){ //switch for left mergesort first
				if (left.size() > 0){
					printer(left);
					}
				left = mergeSort(left, 1);
				if (right.size() > 0){
					printer(right);
				}
				right = mergeSort(right, 0);
			}
			else{ //switch for right mergesort first
				if (right.size() > 0){
					printer(right);
				}
				right = mergeSort(right, 0);
				if (left.size() > 0){
					printer(left);
					}
				left = mergeSort(left, 1);
			}
			return merge(left, right);
		}
	}
	
	public static List<Integer> merge(List<Integer> list1, List<Integer> list2){ //same merge function as in Q1
		List<Integer> finallist = new LinkedList<Integer>();
		while (list1.size() > 0 || list2.size() > 0){
			if (list1.size() > 0 && list2.size() > 0){
				if (list1.get(0) <= list2.get(0)){
					finallist.add(list1.get(0));
					list1.remove(0);
				}
				else{
					finallist.add(list2.get(0));
					list2.remove(0);
				}
			}
			else if (list1.size() > 0){
				finallist.add(list1.get(0));
				list1.remove(0);
			}
			else if (list2.size() > 0){
				finallist.add(list2.get(0));
				list2.remove(0);
			}
		}
		return finallist;
	}
	
	public static void main(String[] args){
		List<Integer> test = new LinkedList<Integer>();
		Random generator = new Random();
		/*for (int i = 0; i < 8; i++){
			test.add(generator.nextInt(50));
		}*/
		for (int i = 100; i > 0; i--){
			test.add(i);
		}
		printer(test);
		test = mergeSort(test, 0);
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
