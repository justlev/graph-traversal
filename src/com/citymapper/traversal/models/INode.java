package com.citymapper.traversal.models;

public interface INode {
    Iterable<IEdge> getEdges();
    void addEdge(IEdge edge);
}
