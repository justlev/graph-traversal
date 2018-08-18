package com.citymapper.traversal.services.data_providers;

import com.citymapper.traversal.errors.NotFoundError;
import com.citymapper.traversal.models.IGraph;
import com.citymapper.traversal.models.INode;

import java.io.IOException;

// A provider for the graph. Can be a file, can be anything else.
public interface IDataProvider {
    IGraph getGraph(String origin) throws NotFoundError, IOException;
}
