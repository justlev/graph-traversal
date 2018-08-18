package com.citymapper.traversal;

import com.citymapper.traversal.algorithms.ITraversalAlgorithm;
import com.citymapper.traversal.container.DefaultContainer;
import com.citymapper.traversal.errors.NotFoundError;
import com.citymapper.traversal.models.IGraph;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3){
            System.out.println("Need to provide 3 arguments: graph input file, source, destination");
            return;
        }
        String path = args[0];
        String from = args[1];
        String to = args[2];
        IGraph graph = null;
        try {
            graph = DefaultContainer.getInstance().getDataProvider().getGraph(path);
        } catch (NotFoundError notFoundError) {
            System.out.println(String.format("Source %s was not found!", path));
        } catch (IOException e) {
            System.out.println("File is in wrong format!");
            e.printStackTrace();
        }
        if (graph == null){
            return;
        }
        // Get current algorithm to use from the container.
        ITraversalAlgorithm selectedAlgorithm = DefaultContainer.getInstance().getTraversalAlgorithm();

        // Traverse the graph, find shortest path.
        int result = selectedAlgorithm.findShortestPath(graph, from, to);
        if (result == -1){
            System.out.println("No path exists");
        }
        else {
            System.out.println("Shortest path: "+result);
        }
    }
}
