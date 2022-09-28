package com.mytest.sep2022;

public class MyArrayUtils {
	
	/**
	 * This method returns the longest monotone sub array of elements from the given list of elements
	 * @param elementsArr
	 * @return longest monotone sub array from the given input array of elements
	 */
	public static int[] getLongestMonotoneSubArray(int[] elementsArr) {
		if( elementsArr == null || elementsArr.length == 0 ) {
			return new int[] {};
		}
		if( elementsArr.length == 0 ) {
			return new int[] {elementsArr[0]};
		}
		
		int prevLongSubArrIndexA = 0;
		int prevLongSubArrIndexB = 0;
		int prevLongSubArrLength = 1;
		
		int subArrStartIndex = 0;
		
		int i=1;
		while(i<elementsArr.length) {
			if( elementsArr[i] <elementsArr[i-1]) {
				int subArrLength = i-subArrStartIndex;
				if( subArrLength > prevLongSubArrLength) {
					//change teh longest monotone subarray as the new one
					prevLongSubArrIndexA = subArrStartIndex;
					prevLongSubArrIndexB = i-1;
					prevLongSubArrLength = prevLongSubArrIndexB - prevLongSubArrIndexA + 1;
					
				}
				subArrStartIndex = i;
			}
			i++;
		}
		
		int subArrLength = elementsArr.length - subArrStartIndex;
		if( subArrLength > prevLongSubArrLength) {
			prevLongSubArrIndexA = subArrStartIndex;
			prevLongSubArrIndexB = elementsArr.length - 1;
			prevLongSubArrLength = prevLongSubArrIndexB - prevLongSubArrIndexA +1;
			
		}
		
		int[] monotoneSubArr = new int[prevLongSubArrLength];
		for(i=0; i<prevLongSubArrLength; i++) {
			monotoneSubArr[i] = elementsArr[prevLongSubArrIndexA+i];
		}
		return monotoneSubArr;
		
	}
}