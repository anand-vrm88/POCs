package org.anverma.datastructures.graph;

import org.anverm.datastructures.graph.MyGraph;
import org.junit.Test;

public class TestMyGraph {

	@Test
	public void test() {
		MyGraph g = new MyGraph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.BFS(2);
		g.DFS(2);
	}

}
