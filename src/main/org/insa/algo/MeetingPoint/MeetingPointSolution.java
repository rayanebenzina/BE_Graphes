package org.insa.algo.MeetingPoint;

import org.insa.algo.AbstractInputData;
import org.insa.algo.AbstractSolution;
import org.insa.algo.AbstractSolution.Status;
import org.insa.graph.Node;
@SuppressWarnings("unused")
public class MeetingPointSolution extends AbstractSolution {
	@SuppressWarnings("unused")
	private Node nodeList[];
	protected MeetingPointSolution(AbstractInputData data) {
		super(data);
	}
	protected MeetingPointSolution(MeetingPointData data, Status status) {
		super(data,status);
	}
	public MeetingPointSolution(MeetingPointData data, Status status, Node nodeList[]) {
        super(data, status);
        this.setNodeList(nodeList);
    }
	public MeetingPointData getInputData() {
        return (MeetingPointData) super.getInputData();
    }
	public void setNodeList(Node nodeList[]) {
		this.nodeList = nodeList;
	}

}
