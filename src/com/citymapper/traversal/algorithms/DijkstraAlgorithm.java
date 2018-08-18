package com.citymapper.traversal.algorithms;

import com.citymapper.traversal.models.IGraph;
import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IEdge;

import java.util.HashMap;
import java.util.HashSet;

public class DijkstraAlgorithm implements ITraversalAlgorithm {

    private final HashSet<INode> unvisitedNodes;
    private final HashMap<INode,Integer> _distances;

    public DijkstraAlgorithm(){
        unvisitedNodes = new HashSet<>();
        _distances = new HashMap<>();
    }

    @Override
    public int findShortestPath(IGraph graph, String from, String to) {
        // Fill all graph nodes to unvisited list
        for (INode item : graph.getAllKeys()){
            unvisitedNodes.add(item);
        }
        //Set starting node
        _distances.put(graph.getNode(from), 0);

        //Traverse until shortest path is found
        INode targetNode = graph.getNode(to);
        findShortestPathTo(targetNode);

        //Get shortest length to target node
        int result = _distances.get(targetNode);

        //Cleanup
        unvisitedNodes.clear();
        _distances.clear();

        return result;
    }

    private void findShortestPathTo(INode target_node) {
        while (!unvisitedNodes.isEmpty() && unvisitedNodes.contains(target_node)) {
            INode currentItem = getClosestItem(unvisitedNodes); //Find node with shortest path
            if (currentItem == null) return; //If not found - no need to continue looking
            unvisitedNodes.remove(currentItem);
            int currentDistance = _distances.get(currentItem); //get current distance for that node
            for (IEdge edge : currentItem.getEdges()) {
                INode target = edge.getTarget();
                int distanceToTarget = edge.getLength();
                int newDistance = currentDistance + distanceToTarget; //New distance is distance to current point + distance to target edge
                if (!_distances.containsKey(target)) {
                    _distances.put(target, newDistance); //If target edge's distance is still not saved - save it
                } else if (_distances.get(target) > newDistance) {
                    _distances.replace(target, newDistance); //If new distance is shorter than previous one - replace the previous one.
                }
            }
        }
    }

    private INode getClosestItem(HashSet<INode> nodes){
        INode minItem = null;
        int minDistance = Integer.MAX_VALUE;
        if (nodes.size() < _distances.size()){ //Always iterate over shortest collection to save time. Check if key exists in hashmap.
            for (INode node : nodes){
                if (_distances.containsKey(node)){
                    int distance = _distances.get(node);
                    if (distance < minDistance || minItem == null){
                        minDistance = distance;
                        minItem = node;
                    }
                }
            }
        }
        else{
            for (INode node : _distances.keySet()){
                if (nodes.contains(node)){
                    int distance = _distances.get(node);
                    if (distance < minDistance || minItem == null){
                        minDistance = distance;
                        minItem = node;
                    }
                }
            }
        }

        return minItem;
    }
}
