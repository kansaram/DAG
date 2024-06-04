* First step in directed acyclic graph is sort it in topological order to determine weather it has cycle or not and all the nodes are processed only after it's dependencies are processed.
* For topological sorting we use Depth First Traversal.
* For finding the longest path in DAG we follow Dijkstra's algorithm "how we can determine shortest path in a DAG".
* We negate the weight on the edges between vertices and find the shortest path using Dijkstra's algorithm to each node from starting node.
* Then again negate the weight on the edges between vertices and the path that we determined is the longest path from source node to end node.

* Large graph has some disadvantages as well. First and formost is it's difficult to visualize a graph like cause and effect of any disease. Even modification is not easy and complicated.
* It can be optimized using Depth First Search instead of Breath First Search algorithm.
* Computational complexity of solution is O(V + E) where V is the Vertex and E is the Edge.
* Cases which are not handled is there can be more then one starting node. Which can be determined by inbound edges as zero.
