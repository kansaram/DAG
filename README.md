* First step in directed acyclic graph is sort it in topological order to determine weather it has cycle or not and all the nodes are processed only after it's dependencies are processed.
* For topological sorting we use Depth First Traversal.
* For finding the longest path in DAG we follow Dijkstra's algorithm "how we can determine shortest path in a DAG".
* We negate the weight on the edges between vertices and find the shortest path using Dijkstra's algorithm to each node from starting node.
* Then again negate the weight on the edges between vertices and the path that we determined is the longest path from source node to end node.  
