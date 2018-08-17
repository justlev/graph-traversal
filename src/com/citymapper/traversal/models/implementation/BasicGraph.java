package com.citymapper.traversal.models.implementation;

import com.citymapper.traversal.models.IGraph;
import com.citymapper.traversal.models.INode;

import java.util.HashMap;

public class BasicGraph implements IGraph {

    private final HashMap<String,INode> _hash;

    public BasicGraph(){
        _hash = new HashMap<>();
    }

    @Override
    public void addNode(String key) {
        if (!_hash.containsKey(key)){
            _hash.put(key, new Node(key));
        }
    }

    @Override
    public INode getNode(String key) {
        return _hash.get(key);
    }

    @Override
    public Iterable<INode> getAllKeys() {
        return _hash.values();
    }
}
