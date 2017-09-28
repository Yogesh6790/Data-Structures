package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GraphNode<T> {
	T data;
	boolean visited;
	LinkedList<GraphNode> neighbors;

	GraphNode(T data) {
		this.data = data;
		this.neighbors = new LinkedList<>();
	}
}

public class DFStoFindBuildOrder {
	
	private static int counter;
	private static String buildPath = "";
	private static boolean cycle;
	
	public static void main(String args[]) {
		System.out.println(counter);
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");
		GraphNode f = new GraphNode("f");
		List<GraphNode> list = new ArrayList<GraphNode>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);

		// adding neighbors
		a.neighbors.add(d);
		d.neighbors.add(b);
		b.neighbors.add(f);
		f.neighbors.add(a);

		//
		for (int i = 0; i < list.size(); i++) {
			List<String> list1 = new ArrayList<String>();
			dfs(list.get(i),list1);
			if (cycle) {
				System.out.println("Compile build error");
				break;
			}
			if (counter == list.size()) {
				System.out.println(buildPath);
				break;
			}
		}

	}

	private static void dfs(GraphNode a, List<String> list1) {
		if(list1.contains(a.data.toString())){
			cycle = true;
			return;
		}
		if (!a.visited) {
			list1.add(a.data.toString());
			a.visited = true;
			List<GraphNode> neighbors = a.neighbors;
			for (int i = 0; i < neighbors.size(); i++) {
				dfs(neighbors.get(i),list1);
			}
			list1.remove(a.data.toString());
			buildPath += a.data;
			counter++;
		}

	}

}
