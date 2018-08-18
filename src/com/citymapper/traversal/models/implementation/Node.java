package com.citymapper.traversal.models.implementation;

import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IEdge;

import java.util.ArrayList;

public class Node implements INode {

    private final String _key;
    private final ArrayList<IEdge> _edges;

    public Node(String key){
        _key = key;
        _edges = new ArrayList<>();
    }

    @Override
    public Iterable<IEdge> getEdges() {
        return _edges;
    }

    @Override
    public void addEdge(IEdge edge) {
        _edges.add(edge);
    }
}
