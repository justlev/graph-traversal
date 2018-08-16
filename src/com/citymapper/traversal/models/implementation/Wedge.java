package com.citymapper.traversal.models.implementation;

import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.IWedge;

public class Wedge implements IWedge {

    private final int _length;
    private final INode _target;

    public Wedge(int length, INode target){
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
