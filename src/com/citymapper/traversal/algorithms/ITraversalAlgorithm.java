package com.citymapper.traversal.algorithms;

import com.citymapper.traversal.models.IGraph;

public interface ITraversalAlgorithm {
    int findShortestPath(IGraph graph, String from, String to);
}
