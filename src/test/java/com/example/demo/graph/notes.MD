## DFS
the depth-first search algorithm is mainly used to:
1) Traverse all vertices in a “graph”;
2) Traverse all paths between any two vertices in a “graph”
The main idea is to go as further as you can down the graph until you cant go any further and than backtrack  to look at other paths
STACK


## BFS used for
1) Traversing all vertices in the “graph”;
2) Finding the shortest path between two vertices in a graph where all edges have equal and positive weights.
The main idea is to search by levels and go down until all levels were searched.
Queue
We choose one path and search all vertices level by level until we cant go any further. We go lawyer by lawyer


## Spanning tree
Covers all vertices with minimum possible edges.
If number of vertices is V, number of the edges will be V-1 to cover all vertices.

Cut Property. 
The edge with the minimum weight is also the edge of the MST.

# Kruskals' Algorithm:
1) Ascending sort of all edges by their weight. That would take O(ElogE)  where E is the number of edges
2) Add edges in the ascending order to the MST. Skip the edges that would produce a cycle.
3) Repeat step 2 until you have V-1 edges where V is the number of vertices

Time: O(ElogE)
Space (V) - you need to store V verticies in the data structure

# Prim's Algorithm:
1. You should have 2 sets of vertices: visited and unvisited
2. Pick an arbitrary vertice from unvisited vertices set as your starting point
3. Out of all edges coming out of that vertice, find the edge of the minimum weight, add it to the visited set. We found our next vertice.
4. Keep expanding visted vertices set until you reach N-1 edges.

Time: O(ElogV). 
    1. We need O(V+E) to traverse all vertices of the graph and add it to the heap
    2. Extract minimum element from min heap takes O(logV) time
    3. Therefore it takes O(V+E) *O(logV) = O(E)log(V)
Space (V) - you need to store V verticies in the data structure
# The difference between the “Kruskal’s algorithm” and the “Prim’s algorithm”
“Kruskal’s algorithm” expands the “minimum spanning tree” by adding edges. 
Whereas “Prim’s algorithm” expands the “minimum spanning tree” by adding vertices.


## Dijkstra's algorithm
“Dijkstra's algorithm” can only be used to solve the “single source shortest path” problem in a graph with 
positive weights.

Network Delay Time