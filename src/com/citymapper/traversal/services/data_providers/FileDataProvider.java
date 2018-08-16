package com.citymapper.traversal.services.data_providers;

import com.citymapper.traversal.errors.NotFoundError;
import com.citymapper.traversal.models.IGraph;
import com.citymapper.traversal.models.INode;
import com.citymapper.traversal.models.implementation.BasicGraph;
import com.citymapper.traversal.models.implementation.Wedge;

import java.io.*;

public class FileDataProvider implements IDataProvider {

    @Override
    public IGraph getGraph(String origin) throws NotFoundError, IOException {
        File file = new File(origin);
        IGraph graph = new BasicGraph();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new NotFoundError(origin);
        }

        String st;
        while ((st = br.readLine()) != null) {
            String[] splitted = st.split(" ");
            if (splitted.length == 1){
                appendNode(graph, splitted[0]);
            }
            else if (splitted.length == 3){
                appendWedge(graph, splitted[0], splitted[1], Integer.parseInt(splitted[2]));
            }
        }
        return graph;
    }

    private void appendNode(IGraph graph, String key){
        graph.addNode(key);
    }

    private void appendWedge(IGraph graph, String from, String to, int length){
        INode origin = graph.getNode(from);
        INode target = graph.getNode(to);
        origin.addWedge(new Wedge(length, target));
        target.addWedge(new Wedge(length, origin));
    }
}
