package com.mytest.sep2022;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class RecordUtilsTest{
	
	@Test
	public void simpleRecordSetNullTest() {
		TreeNode rootNode = RecordUtils.convertToSortedTree(null);
		assertNull(rootNode);
	}
	
	@Test
	public void simpleRecordSetSingleRecordTest() {
		TreeNode rootNode = RecordUtils.convertToSortedTree(new String[] {"1.2.3"});
		assertNotNull(rootNode);
		
		String treeString = rootNode.toString();
		String expectedStr = getStringOfLines("1","--2","----3");
		assertEquals(expectedStr, treeString);
	}
	
	@Test
	public void simpleRecordSet2RecordsTest() {
		TreeNode rootNode = RecordUtils.convertToSortedTree(new String[]{"1.2.3", "1.2.5"});
		assertNotNull(rootNode);
		
		String treeString = rootNode.toString();
		String expectedStr = getStringOfLines("1","--2","----3", "----5");
		assertEquals(expectedStr, treeString);
	}
	
	@Test
	public void simpleRecordSet3RecordsTest() {
		TreeNode rootNode = RecordUtils.convertToSortedTree(new String[]{"1.2.3","1.2.5", "2.5.6"});
		assertNotNull(rootNode);
		
		String treeString = rootNode.toString();
		String expectedStr = getStringOfLines("1","--2","----3", "----5", "2", "--5", "----6"); 

		assertEquals(expectedStr, treeString);
	}
	
	@Test
	public void simpleRecordSet7RecordTest() {
		TreeNode rootNode = RecordUtils.convertToSortedTree(new String[]{"1.2.3","1.2.5", "1.5.6","1.2.4", "2.5.6", "1.5.7", "2.5.3"});
		assertNotNull(rootNode);
		
		String treeString = rootNode.toString();
		String expectedStr = getStringOfLines("1", "--2","----3","----4","----5","--5","----6","----7","2", "--5","----3","----6");
		assertEquals(expectedStr, treeString);
	}
	
	private String getStringOfLines(String... lines){
		StringBuilder result = new StringBuilder();
		for(String line: lines) {
			result.append(line + System.lineSeparator());
		}
		return result.toString();
	}
	
}