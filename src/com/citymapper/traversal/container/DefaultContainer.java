package com.citymapper.traversal.container;

import com.citymapper.traversal.algorithms.DijkstraAlgorithm;
import com.citymapper.traversal.algorithms.ITraversalAlgorithm;
import com.citymapper.traversal.services.data_providers.FileDataProvider;
import com.citymapper.traversal.services.data_providers.IDataProvider;

public class DefaultContainer implements IContainer {

    private final FileDataProvider _dataProvider;
    private final DijkstraAlgorithm _traversalAlgorithm;

    private static IContainer _instance;

    public DefaultContainer(){
        _traversalAlgorithm = new DijkstraAlgorithm();
        _dataProvider = new FileDataProvider();
    }

    @Override
    public ITraversalAlgorithm getTraversalAlgorithm() {
        return _traversalAlgorithm;
    }

    @Override
    public IDataProvider getDataProvider() {
        return _dataProvider;
    }

    public static IContainer getInstance(){
        if (_instance == null){
            _instance = new DefaultContainer();
        }
        return _instance;
    }

}
