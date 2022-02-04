package graphADT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * @param <T>
 */
public class Graph<T extends Comparable<T>> implements IGraph<T>{
	
	final private HashMap<T, Set<T>> adjList;
    /**
     * Create new Graph object.
     */
    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (this.adjList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.adjList.put(vertex, new HashSet<T>());
    }
    
    /**
     * Remove the node(vertex) vertex from the graph.
     * @param vertex The vertex to be removed.
     */
    public void removeVertex(T vertex) {
        if (!this.adjList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }
        
        this.adjList.remove(vertex);
        
        for (T v: this.getAllVertices()) {
            this.adjList.get(v).remove(vertex);
        }
    }
    
    /**
     * Add an edge between vertices. 
     * @param vertex Start vertex.
     * @param dVertex Destination vertex.
     */
    public void addEdge(T vertex, T dVertex) {
        if (!this.adjList.containsKey(vertex) || !this.adjList.containsKey(dVertex)) {
            throw new IllegalArgumentException("Provided vertex does not exit!");
        }
        //Connect in both ways since the graph is undirected.
        this.adjList.get(vertex).add(dVertex);
        this.adjList.get(dVertex).add(vertex);
    }
    
    public void removeEdge(T vertex, T dVertex) {
        if (!this.adjList.containsKey(vertex) || !this.adjList.containsKey(dVertex)) {
            throw new IllegalArgumentException("Provided vertex does not exit!");
        }
        
        //Remove edge for both ways since the graph is undirected.
        this.adjList.get(vertex).remove(dVertex);
        this.adjList.get(dVertex).remove(vertex);
    }

    public boolean isAdjacent(T vertex, T dVertex) {
        return this.adjList.get(vertex).contains(dVertex);
    }
    public Iterable<T> getNeighbors(T vertex) {
        return this.adjList.get(vertex);
    }

    public Iterable<T> getAllVertices() {
        return this.adjList.keySet();
    }
	
}
