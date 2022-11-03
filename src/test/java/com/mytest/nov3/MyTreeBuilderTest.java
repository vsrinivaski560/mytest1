package com.mytest.nov3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTreeBuilderTest {

	@Test
	public void simpleTreeBuildTest() {
		Node rootNode = MyTreeBuilder.buildTree(new int[][] {{4, 5},{5,3}, {1,5}, {2,1}});
		assertNotNull(rootNode);
		assertEquals(1, rootNode.getValue());
		List<Node> firstChilds = rootNode.getChildren();
		assertNotNull(firstChilds);
		assertEquals(2, firstChilds.size());
		System.out.println(rootNode);
	}
	
	@Test
	public void simpleTreeBuildTest2() {
		Node rootNode = MyTreeBuilder.buildTree(new int[][] {{4, 5},{5,3}, {1,5}, {2,5}});
		assertNotNull(rootNode);
		assertEquals(1, rootNode.getValue());
		List<Node> firstChilds = rootNode.getChildren();
		assertNotNull(firstChilds);
		assertEquals(1, firstChilds.size());
		System.out.println(rootNode);
	}
	
	@Test
	public void simpleTreeBuildTest3() {
		Node rootNode = MyTreeBuilder.buildTree(new int[][] {{4, 5},{4,3}, {1,4}, {2,1}, {4, 2}, {2, 7}});
		assertNotNull(rootNode);
		assertEquals(1, rootNode.getValue());
		List<Node> firstChilds = rootNode.getChildren();
		assertNotNull(firstChilds);
		assertEquals(2, firstChilds.size());
		System.out.println(rootNode);
	}
	
}
