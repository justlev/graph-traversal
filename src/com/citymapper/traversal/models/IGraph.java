package com.citymapper.traversal.models;

public interface IGraph {
    void addNode(String key);
    INode getNode(String key);
    Iterable<INode> getAllKeys();
}
