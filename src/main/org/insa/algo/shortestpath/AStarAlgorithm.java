package org.insa.algo.shortestpath;
import org.insa.algo.AbstractInputData;
import org.insa.algo.AbstractInputData.Mode;
import org.insa.graph.LabelStar;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data)
    {
        super(data);
    } 
    @Override
    protected void initLabels()
    {
        labels = new LabelStar[nodesNb];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new LabelStar(i,calcEstimatedCost(i,idDestination));
        }
        labels[idOrigin].setCost(0);
    }
    protected double calcEstimatedCost(int currentNode, int destination)
    {
    	AbstractInputData.Mode mode = data.getMode();
        double d = graph.get(currentNode).getPoint().distanceTo(data.getDestination().getPoint());
		return (mode == Mode.LENGTH) ? d : d / (double) (1000 * data.getMaximumSpeed());
    }
}
