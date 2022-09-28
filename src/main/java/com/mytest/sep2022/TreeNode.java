package com.mytest.sep2022;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TreeNode{
	private String value;
	
	Set<TreeNode> sortedChilds = new TreeSet<TreeNode> (new Comparator<TreeNode>() {
		
		public int compare(TreeNode o1, TreeNode o2) {
			if( o1 == o2) {
				return 0;
			}
			if( o1 == null && o2 != null ) {
				return 1;
			}
			if( o2==null && o1 != null ) {
				return -1;
			}
			String o1Val = o1.getValue();
			String o2Val = o2.getValue();
			
			if( o1Val == o2Val) {
				return 0;
			}
			if( o1Val == null && o2Val != null ) {
				return 1;
			}
			if( o2Val==null && o1Val != null ) {
				return -1;
			}
			return o1Val.compareTo(o2Val);
		}
		
	});
	
	Map<String, TreeNode> childKeyVsNode = new HashMap();
	
	public TreeNode() {
		
	}
	
	public TreeNode(String val ) {
		this.value = val;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String toString() {
		StringWriter stringWriter = new StringWriter(1024);
		PrintWriter pr = new PrintWriter(stringWriter);
		printTree(pr, 0);
		pr.flush();
		return stringWriter.toString();
	}
	
	public void printTree(PrintWriter pr, int level) {
		StringBuilder prefix = new StringBuilder("");
		for(int i=0; i<level; i++) {
			prefix.append("--");
		}
		for(TreeNode childNode:sortedChilds) {
			pr.println(prefix.toString() + childNode.getValue());
			childNode.printTree(pr, level+1);
		}
	}
	
	public void addRecord(String record) {
		String[] elements = record.split("\\.");
		addRecordElements(elements);
	}
	
	public void addRecordElements(String[] elements) {
		TreeNode parentNode = this;
		for ( String element:elements) {
			parentNode = parentNode.addChild(element);
		}
	}
	
	private TreeNode addChild(String element) {
		TreeNode childNode = childKeyVsNode.get(element);
		if( childNode == null ) {
			childNode = new TreeNode(element);
			sortedChilds.add(childNode);
			childKeyVsNode.put(element, childNode);
		}
		return childNode;
	}
	
}