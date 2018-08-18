package com.citymapper.traversal.models.implementation;

import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IEdge;

public class Edge implements IEdge {

    private final int _length;
    private final INode _target;

    public Edge(int length, INode target){
        _length = length;
        _target = target;
    }

    @Override
    public Integer getLength() {
        return _length;
    }

    @Override
    public INode getTarget() {
        return _target;
    }
}
