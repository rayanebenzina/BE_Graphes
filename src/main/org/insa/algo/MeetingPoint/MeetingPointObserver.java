package org.insa.algo.MeetingPoint;

import org.insa.graph.Node;

public interface MeetingPointObserver {
	
	public void notifyNodeInMiddle(Node node);
	public void notifyEqualCosts(Node node);
	public void notifyIsSolution(Node node);
	
}
