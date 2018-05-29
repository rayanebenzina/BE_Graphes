package org.insa.algo.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import org.insa.algo.AbstractSolution.Status;
import org.insa.algo.utils.BinaryHeap;
import org.insa.graph.Arc;
import org.insa.graph.Graph;
import org.insa.graph.Label;
import org.insa.graph.Node;
import org.insa.graph.Path;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {
	
	protected Label labels[];
	protected BinaryHeap<Label> tas;
	protected ShortestPathData data;
	protected int idOrigin,idDestination;
	protected int nodesNb;
	protected Graph graph;
	
    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
        this.data = data;
        this.graph = data.getGraph();
		this.nodesNb = graph.size();
		this.idOrigin = data.getOrigin().getId();
		initLabels();
		this.idDestination = data.getDestination().getId();
		this.tas = new BinaryHeap<>();
		this.tas.insert(labels[idOrigin]);
    }

    protected void initLabels() {
		labels = new Label[nodesNb];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label(i);
		}
		labels[idOrigin].setCost(0);
	}

    @Override
    protected ShortestPathSolution doRun() {
    	
		notifyOriginProcessed(data.getOrigin());
		process();
        return solution();
    }
    
    protected ShortestPathSolution solution()
    {
    	if(labels[data.getDestination().getId()].getPere() == null)
		{
			return new ShortestPathSolution(data, Status.INFEASIBLE);
		}
		notifyDestinationReached(data.getDestination());
		
		ArrayList<Arc> path = new ArrayList<Arc>();
		Arc arc = labels[data.getDestination().getId()].getPere();
		while (arc != null) {
			path.add(arc);
			arc = labels[arc.getOrigin().getId()].getPere();
		}
		Collections.reverse(path);
		return new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, path));
    }
    
    private void process()
    {
    	int idx;
    	do
		{
			Label lx = tas.deleteMin();
			idx = lx.getId();
			Node nx = graph.get(idx);
			lx.Mark();
			ArrayList<Arc> successors = nx.getSuccessors();
			for(Arc successor : successors)
			{
				if(data.isAllowed(successor))
				{
					Label ly = labels[successor.getDestination().getId()];
					if(!ly.isMarked())
					{
						double newCost = lx.getCost() + data.getCost(successor);
						if(ly.getCost()>newCost)
						{
							ly.setCost(newCost);
							if(!tas.exists(ly))
							{
								tas.insert(ly);
								notifyNodeReached(successor.getDestination());
							}
							else
							{
								tas.update();
							}
							ly.setPere(successor);
						}
					}
					
				}
				
			}
				
		
		}while(!tas.isEmpty() && idx != idDestination);
    }
}
