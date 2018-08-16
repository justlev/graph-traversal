package com.citymapper.traversal.algorithms;

import com.citymapper.traversal.models.IGraph;
import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IWedge;

import java.util.HashMap;
import java.util.HashSet;

public class DijkstraAlgorithm implements ITraversalAlgorithm {

    private final HashSet<String> _visitedNodes;
    private final HashMap<String,Integer> _distances;

    public DijkstraAlgorithm(){
        _visitedNodes = new HashSet<>();
        _distances = new HashMap<>();
    }

    @Override
    public int findShortestPath(IGraph graph, String from, String to) {
        _visitedNodes.add(from);
        _distances.put(from, 0);

        traverse_recursively(graph, from, to);
        int result = _distances.get(to);

        _visitedNodes.clear();
        _distances.clear();

        return result;
    }

    private void traverse_recursively(IGraph graph, String current_node, String target_node) {
        _visitedNodes.add(current_node);
        INode node = graph.getNode(current_node);
        int current_distance = _distances.get(current_node);
        for (IWedge wedge : node.getWedges()){
            String target = wedge.getTarget().getKey();
            if (!_visitedNodes.contains(target)){
                int distanceToTarget = wedge.getLength();
                int new_distance = current_distance + distanceToTarget;
                if (!_distances.containsKey(target)){
                    _distances.put(target, new_distance);
                }
                else if (_distances.get(target) > new_distance){
                    _distances.replace(target, new_distance);
                }
            }
        }
        for (IWedge wedge : node.getWedges()){
            if (!visitedAllWedges(graph, target_node) && !_visitedNodes.contains(wedge.getTarget().getKey())){
                traverse_recursively(graph, wedge.getTarget().getKey(), target_node);
            }
        }
    }

    private boolean visitedAllWedges(IGraph graph, String target){
        INode node = graph.getNode(target);
        for (IWedge wedge : node.getWedges()){
            if (!_visitedNodes.contains(wedge.getTarget().getKey())){
                return false;
            }
        }
        return true;
    }
}
