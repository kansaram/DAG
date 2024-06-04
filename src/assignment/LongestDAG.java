package assignment;

import java.util.Stack;
import java.util.stream.Collectors;

public class LongestDAG {
	private Vertex[] v;
	private Stack<Vertex> s;
	private boolean visited[];
	private Vertex[] tsVertex;
	private int [] dist;
	private Vertex [] pred;
	private int vertexSize;
	
	public LongestDAG(int vertexSize){
		this.vertexSize = vertexSize;
		this.v = new Vertex[vertexSize];
		this.s = new Stack<>();
		this.visited = new boolean[vertexSize];
		this.tsVertex = new Vertex[vertexSize];
		this.dist = new int[vertexSize];
		this.pred = new Vertex[vertexSize];
	}
 
	public void topologySort(Vertex v, boolean[] visited, Stack s) {
		visited[v.getData()] = true;
		for(Edge e:v.getEdges()) {
			if(!visited[e.getEnd().getData()]) {
				topologySort(e.getEnd(),visited,s);
			}
		}
		s.push(v);
	}
	
	public Vertex[] topologyOrder(Stack s){
		int i = 0;
		while(!s.isEmpty()) {
			tsVertex[i++] = (Vertex) s.pop();
			
		}
		return tsVertex;
	}
	
	public void shortestPath() {
		for(int i = 0; i < vertexSize ; i++) {
			dist[i] = Integer.MAX_VALUE;
			
		}
		dist[0] = 0;
		pred[0] = null;
		for(Vertex v:tsVertex) {
			for(Edge e:v.getEdges()) {
				int newValue = e.getWeight();
				if(dist[e.getEnd().getData()] > newValue + dist[e.getStart().getData()]) {
					dist[e.getEnd().getData()] = newValue + dist[e.getStart().getData()];
					pred[e.getEnd().getData()] = e.getStart();
				}
			}
		}
		
	}
	public void path(Vertex v) {
		s.push(v);
		while(pred[v.getData()] != null) {
			s.push(pred[v.getData()]);
			v = pred[v.getData()];
		}
		
		while(!s.isEmpty()) {
			
			System.out.print(s.pop().getData() + " -> ");
		}
		
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(true,true);
		Vertex V0 = g.addVertex(0);
		Vertex V1 = g.addVertex(1);
		Vertex V2 = g.addVertex(2);
		Vertex V3 = g.addVertex(3);
		Vertex V4 = g.addVertex(4);
		Vertex V5 = g.addVertex(5);
		Vertex V6 = g.addVertex(6);
		Vertex V7 = g.addVertex(7);
		
		g.negEdge(V0, V1, 3,true);
		g.negEdge(V0, V2, 6,true);
		g.negEdge(V1, V2, 4,true);
		g.negEdge(V1, V3, 4,true);
		g.negEdge(V2, V3, 8,true);
		g.negEdge(V1, V3, 4,true);
		g.negEdge(V1, V4, 11,true);
		g.negEdge(V3, V4, -4,true);
		g.negEdge(V3, V5, 5,true);
		g.negEdge(V3, V6, 2,true);
		g.negEdge(V2, V6, 11,true);
		g.negEdge(V4, V7, 9,true);
		g.negEdge(V5, V7, 1,true);
		g.negEdge(V6, V7, 2,true);
		
		LongestDAG ld = new LongestDAG(8);
		ld.topologySort(V0,ld.visited,ld.s);
		ld.topologyOrder(ld.s);
		for(Vertex v:ld.tsVertex) {
			System.out.print(v.getData() +" ");
		}
		System.out.println();
		
		ld.shortestPath();
		ld.path(V7);
		
	}

}
