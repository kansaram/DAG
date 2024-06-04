package assignment;

public class Edge implements Comparable<Edge>{
  private Vertex start;
  private Vertex end;
  private Integer weight;
	
  public Edge(Vertex startV, Vertex endV, Integer inputWeight) {
    this.start = startV;
    this.end = endV;
    this.weight = inputWeight;
  }
	
  public Vertex getStart() {
    return this.start;
  }
	
  public Vertex getEnd() {
    return this.end;
  }
	
  public Integer getWeight() {
    return this.weight;
  }

@Override
public int compareTo(Edge o) {
	// TODO Auto-generated method stub
	return Integer.compare(this.weight, o.weight);
}
	
}