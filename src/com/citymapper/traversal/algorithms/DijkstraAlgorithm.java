package com.citymapper.traversal.algorithms;

import com.citymapper.traversal.models.IGraph;
import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IWedge;

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
        for (INode item : graph.getAllKeys()){
            unvisitedNodes.add(item);
        }
        _distances.put(graph.getNode(from), 0);
        traverse(graph.getNode(to));
        int result = _distances.get(graph.getNode(to));

        unvisitedNodes.clear();
        _distances.clear();

        return result;
    }

    private void traverse(INode target_node) {
        int i = 0;
        int lastProgress = 0;
        while (!unvisitedNodes.isEmpty() && unvisitedNodes.contains(target_node)) {
            int progress = i * 100 / (i + unvisitedNodes.size());
            reportProgressIfRequired(progress, lastProgress);
            lastProgress = progress;
            i++;
            INode currentItem = getClosestItem(unvisitedNodes);
            if (currentItem == null) return;
            unvisitedNodes.remove(currentItem);
            int currentDistance = _distances.get(currentItem);
            for (IWedge wedge : currentItem.getWedges()) {
                INode target = wedge.getTarget();
                int distanceToTarget = wedge.getLength();
                int newDistance = currentDistance + distanceToTarget;
                if (!_distances.containsKey(target)) {
                    _distances.put(target, newDistance);
                } else if (_distances.get(target) > newDistance) {
                    _distances.replace(target, newDistance);
                }
            }
        }
        System.out.println("100%");
    }

    private INode getClosestItem(HashSet<INode> nodes){
        INode minItem = null;
        int minDistance = Integer.MAX_VALUE;
        if (nodes.size() < _distances.size()){
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

    private void reportProgressIfRequired(int progress, int lastProgress){
        if (progress != lastProgress) {
            System.out.println(progress + "%");
        }
    }
}
