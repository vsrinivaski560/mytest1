package com.mytest.sep2022;

public class RecordUtils{
	
	public static TreeNode convertToSortedTree(String[] records) {
		if(records == null || records.length == 0) {
			return null;
		}
		TreeNode rootNode = new TreeNode();
		for(String record:records) {
			rootNode.addRecord(record);
		}
		return rootNode;
	}
}