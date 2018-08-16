package com.citymapper.traversal.models.implementation;

import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IWedge;

import java.util.ArrayList;

public class Node implements INode {

    private final String _key;
    private final ArrayList<IWedge> _wedges;

    public Node(String key){
        _key = key;
        _wedges = new ArrayList<>();
    }

    @Override
    public String getKey() {
        return _key;
    }

    @Override
    public Iterable<IWedge> getWedges() {
        return _wedges;
    }

    @Override
    public void addWedge(IWedge wedge) {
        _wedges.add(wedge);
    }
}
