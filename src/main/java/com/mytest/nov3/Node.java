package com.mytest.nov3;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Node {

	
	private int value;
	private List<Node> children;
	
	public Node(int val) {
		this.value = val;
		children = new ArrayList<Node>();
	}

	public int getValue() {
		return value;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void addChild(int childVal) {
		Node childNode = new Node(childVal);
		addChild(childNode);
	}

	public void addChild(Node childNode) {
		children.add(childNode);
	}
	
	@Override
	public String toString() {
		StringWriter stringWriter = new StringWriter(1024);
		PrintWriter pr = new PrintWriter(stringWriter);
		pr.println( getValue());
		printTree(pr, 1);
		pr.flush();
		return stringWriter.toString();
	}
	
	public void printTree(PrintWriter pr, int level) {
		StringBuilder prefix = new StringBuilder("");
		for(int i=0; i<level; i++) {
			prefix.append("--");
		}
		for(Node childNode:children) {
			pr.println(prefix.toString() + childNode.getValue());
			childNode.printTree(pr, level+1);
		}
	}
}
