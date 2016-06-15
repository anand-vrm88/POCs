package org.anverm.datastructures.graph;

import java.util.LinkedList;

public class MyGraph {
	private int V;
	private LinkedList<Integer> adj[];
	public MyGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public void BFS(int v){
		boolean[] visited = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[v] = true;
		queue.add(v);
		
		while(!queue.isEmpty()){
			int node = queue.poll();
			System.out.print(node + " ");
			for(int adjNode : adj[node]){
				if(!visited[adjNode]){
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
		System.out.println("");
	}
	
	public void DFS(int v){
		boolean[] visited = new boolean[V];
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		visited[v] = true;
		stack.add(v);
		
		while(!stack.isEmpty()){
			int node = stack.pollFirst();
			System.out.print(node+" ");
			for(int adjNode : adj[node]){
				if(!visited[adjNode]){
					visited[adjNode] = true;
					stack.add(adjNode);
				}
			}
		}
		
		System.out.println("");
	}
}
