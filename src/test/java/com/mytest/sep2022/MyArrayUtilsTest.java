package com.mytest.sep2022;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Unit tests for ArrayUtils
 * 
 *
 */
public class MyArrayUtilsTest{
	
	@Test
	public void simpleMonoSubArrayTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {1});
		assertArrayEquals("Expected single element value as the result but not got ", new int[] {1}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayNullTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(null);
		assertArrayEquals("Expected no element array as the result but not got ", new int[] {}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayEmptyTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {});
		assertArrayEquals("Expected no element array as the result but not got ", new int[] {}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayWith2ValuesOrderTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {1,2});
		assertArrayEquals("Expected two element array as the result but not got ", new int[] {1,2}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayWith2ValuesReverseOrderTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {2, 1});
		assertArrayEquals("Expected 1 element array as the result but not got ", new int[] {2}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayWith2NegativeValuesOrderTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {1,-2});
		assertArrayEquals("Expected 1 element array as the result but not got ", new int[] {1}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayWith9ValuesOrderTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {1,2,4,6,7,8,9,10,11});
		assertArrayEquals("Expected 9 element array as the result but not got ", new int[] {1, 2, 4, 6, 7, 8, 9, 10, 11}, monoSubArr);
	}
	
	@Test
	public void simpleMonoSubArrayWith10ValuesOrderTest() {
		int[] monoSubArr = MyArrayUtils.getLongestMonotoneSubArray(new int[] {2, 3,4,8,7,6,1,3,5,7,8,9});
		assertArrayEquals("Expected 6 element array as the result but not got ", new int[] {1, 3, 5,7,8, 9}, monoSubArr);
	}
	
}