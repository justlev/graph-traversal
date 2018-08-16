package com.citymapper.traversal.container;

import com.citymapper.traversal.algorithms.ITraversalAlgorithm;
import com.citymapper.traversal.services.data_providers.IDataProvider;

public interface IContainer {
    ITraversalAlgorithm getTraversalAlgorithm();
    IDataProvider getDataProvider();
}
