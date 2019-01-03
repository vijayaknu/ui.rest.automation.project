package com.practice.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;


public class MaximumTest {
	// determines the largest of three Comparable objects

	static Integer[] a = {1,5,96,5,2,23,6,4,5,6,8,9,17,5,1};
	
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;   // assume x is initially the largest

		if(y.compareTo(max) > 0) {
			max = y;   // y is the largest so far
		}

		if(z.compareTo(max) > 0) {
			max = z;   // z is the largest now                 
		}
		return max;   // returns the largest object   
	}

	@Test()
	public void maxTest() {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 
				3, 4, 5, maximum( 3, 4, 5 ));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
				6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

		System.out.printf("Max of %s, %s and %s is %s\n","pear",
				"apple", "orange", maximum("pear", "apple", "orange"));
		
		Set<Integer> ar = new HashSet<>(Arrays.asList(a));
		
		
		ar.stream().forEach(o -> {System.out.println(o);});
		System.out.println("====================================");
		Arrays.asList(a).stream().forEach(o -> {System.out.println(o);});
	}
	
	
}