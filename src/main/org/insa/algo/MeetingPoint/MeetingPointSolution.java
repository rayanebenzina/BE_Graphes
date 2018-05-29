package org.insa.algo.MeetingPoint;

import org.insa.algo.AbstractInputData;
import org.insa.algo.AbstractSolution;
import org.insa.graph.Node;

public class MeetingPointSolution extends AbstractSolution {
	private Node nodeList[];
	protected MeetingPointSolution(AbstractInputData data) {
		super(data);
	}
	protected MeetingPointSolution(MeetingPointData data, Status status) {
		super(data,status);
	}
	public MeetingPointSolution(MeetingPointData data, Status status, Node nodeList[]) {
        super(data, status);
        this.nodeList = nodeList;
    }
	public MeetingPointData getInputData() {
        return (MeetingPointData) super.getInputData();
    }
	public Node[] getNodeList() {
		return this.nodeList;
	}

}
