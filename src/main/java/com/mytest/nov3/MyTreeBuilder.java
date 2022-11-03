package com.mytest.nov3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyTreeBuilder {

	public static Node buildTree(int[][] edges) {

		Node rootNode = null;
		List<int[]> edgesList = new ArrayList<int[]>();

		Map<Integer, Node> nodesMap = new HashMap<Integer, Node>();
		Map<Integer, Node> connectedNodesMap = new HashMap<Integer, Node>();
		Map<Integer, Integer> arcsMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < edges.length; i++) {
			edgesList.add(edges[i]);
		}

		for (int i = 0; i < edges.length; i++) {
			Node firstNode = connectedNodesMap.get(edges[i][0]);
			Node secondNode = connectedNodesMap.get(edges[i][1]);
			if (edges[i][0] == 1 || edges[i][1] == 1) {
				if (firstNode == null) {
					firstNode = new Node(edges[i][0]);
					nodesMap.put(firstNode.getValue(), firstNode);
				}

				if (secondNode == null) {
					secondNode = new Node(edges[i][1]);
					nodesMap.put(secondNode.getValue(), secondNode);
				}
			}

			if (edges[i][0] == 1) {
				firstNode.addChild(secondNode);
				arcsMap.put(firstNode.getValue(), secondNode.getValue());
				rootNode = firstNode;
				connectedNodesMap.put(firstNode.getValue(), firstNode);
				connectedNodesMap.put(secondNode.getValue(), secondNode);
				edgesList.remove(edges[i]);
			} else if (edges[i][1] == 1) {

				secondNode.addChild(firstNode);
				arcsMap.put(secondNode.getValue(), firstNode.getValue());
				rootNode = secondNode;
				connectedNodesMap.put(firstNode.getValue(), firstNode);
				connectedNodesMap.put(secondNode.getValue(), secondNode);
				edgesList.remove(edges[i]);
			}
		}

		int prevSize = -1;
		while (edgesList.size() != 0) {
			if (edgesList.size() == prevSize) {
				throw new RuntimeException(
						"It is not converging to the single tree, there would be disjoint edges present");
			}
			prevSize = edgesList.size();
			Iterator<int[]> iterator = edgesList.iterator();
			while (iterator.hasNext()) {
				int[] edge = iterator.next();
				Node firstNode = connectedNodesMap.get(edge[0]);
				Node secondNode = connectedNodesMap.get(edge[1]);

				if (firstNode != null && secondNode != null
						&& ((arcsMap.get(firstNode.getValue()) != null
								&& arcsMap.get(firstNode.getValue()) == secondNode.getValue())
								|| (arcsMap.get(secondNode.getValue()) != null
										&& arcsMap.get(secondNode.getValue()) == firstNode.getValue()))) {
					throw new RuntimeException("Duplicate edges encountered {" + edge[0] + " , " + edge[1] + " }");
				} else if (firstNode != null) {
					secondNode = new Node(edge[1]);
					firstNode.addChild(secondNode);
					connectedNodesMap.put(secondNode.getValue(), secondNode);
					iterator.remove();
				} else if (secondNode != null) {
					firstNode = new Node(edge[0]);
					secondNode.addChild(firstNode);
					connectedNodesMap.put(firstNode.getValue(), firstNode);
					iterator.remove();
				}
			}

		}
		return rootNode;
	}

}
