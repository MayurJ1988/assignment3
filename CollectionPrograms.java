package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionPrograms {

	public static void main(String[] args) {

		List<String> fruitList = new ArrayList<String>();
		fruitList.add("Apple");
		fruitList.add("Orange");
		fruitList.add("Mango");
		fruitList.add("Banana");
		
		//Removing an element from specific index
		fruitList.remove(1);
		fruitList.stream().forEach(e -> System.out.println(e));
		
		//Copy all elements of list in Object array
		Object[] objectArray = fruitList.toArray();
		for (Object fruit : objectArray) {
			System.out.println(fruit);
		}
		
		//Creating list from Object array
		List<String> newFruitList = new ArrayList<String>();
		for (Object object : objectArray) {
			if (object instanceof String) {
				newFruitList.add((String)object);
			}
		}
		newFruitList.add("Grape");
		System.out.println("New fruit list:");
		newFruitList.stream().forEach(e -> System.out.println(e));
		
		//Copying one list to another
		List<String> copyList = newFruitList.stream().collect(Collectors.toList());
		copyList.add("Berry");
		System.out.println("Copied fruit list:");
		copyList.stream().forEach(e -> System.out.println(e));;
		
		//Finding minimum and maximum of list
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(2,3,1,7,8,0));
		System.out.println("Minimum element in arraylist: " +Collections.min(intList));
		System.out.println("Maximum element in arraylist: " +Collections.max(intList));
		
		//Getting enumeration over Integer list
		Enumeration<Integer> en = Collections.enumeration(intList);
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
		//Getting synchronized list over a list
		List<String> syncList = Collections.synchronizedList(copyList);
		synchronized (syncList) {
			Iterator<String> iterator = syncList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		
		HashMap<String, Integer> cart = new HashMap<>();
		cart.put("Butter", 5);
		cart.put("Milk", 10);
		cart.put("Rice", 20);
		cart.put("Bread", 2);
		cart.put("Peanut", 2);
		// creating a new synchronized Map from HashMap
		Map<String, Integer> mapSynched = Collections.synchronizedMap(cart);
		System.out.println("New Synchronized Map from HashMap: ");
		// printing synchronized map from HashMap
		synchronized (mapSynched) {
			for (String unKey : mapSynched.keySet()) {
				System.out.println("Item: " + unKey + ", Quantity: " + cart.get(unKey));
			}
		}
		
		//Reversing the order of all elements of list
		System.out.println("Elements of list: "+copyList);
		Collections.reverse(copyList);
		// Print all elements of list in reverse order
		System.out.println("Elements of list in reverse order: "+copyList);
		
		//Shuffle elements of list
		System.out.println("Original list: "+copyList);
		Collections.shuffle(copyList);
		System.out.println("Shuffled list: "+copyList);
		
		//Sort list in descending order using Comparator
		System.out.println("Before sorting: "+intList);
		List<Integer> sortedList = intList.stream()
				                 .sorted(Comparator.reverseOrder())
				                 .collect(Collectors.toList());
		System.out.println("After sorting: "+sortedList);
		
		//Getting values of HashMap and printing
		System.out.println("Values of HashMap: ");
		for (Integer integer : cart.values()) {
			System.out.println(integer);
		}
		
		//Remove value from HashMap
		Integer removedValue = cart.remove("Milk");
		System.out.println("Removed value :"+removedValue);
		for (String unKey : cart.keySet()) {
			System.out.println("Item: " + unKey + ", Quantity: " + cart.get(unKey));
		}
		
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Banana");
		linkedList.add("Orange");
		linkedList.add("Mango");
		//Adding element at beginning of the list
		linkedList.addFirst("Pineapple");
		//Adding element at end of list
		linkedList.addLast("Berry");
		System.out.println("Updated linked list: "+linkedList);
		
		List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(2,3,6,8,10));
		//List before adding element
		System.out.println("List before adding element: "+integerList);
		ListIterator<Integer> iterator = integerList.listIterator();
		//Adding element using list iterator
		iterator.add(100);
		iterator.add(200);
		iterator.add(300);
		System.out.println("List after adding elements using iterator: ");
		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		
		ListIterator<Integer> li = integerList.listIterator(integerList.size());
		//Iterate list in reverse direction using ListIterator
		System.out.println("List in reverse direction: ");
		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}
		
	}

}
