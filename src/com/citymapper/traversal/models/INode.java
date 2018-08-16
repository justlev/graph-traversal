package com.citymapper.traversal.models;

public interface INode {
    String getKey();
    Iterable<IWedge> getWedges();
    void addWedge(IWedge wedge);
}
