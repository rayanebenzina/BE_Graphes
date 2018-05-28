package org.insa.algo.MeetingPoint;

import org.insa.algo.AbstractInputData;
import org.insa.algo.ArcInspector;
import org.insa.graph.Graph;
import org.insa.graph.Node;

public class MeetingPointData extends AbstractInputData {
	private final Node o1,o2;
	public MeetingPointData(Graph graph, Node o1, Node o2, ArcInspector arcInspector) {
        super(graph, arcInspector);
        this.o1 = o1;
        this.o2 = o2;
    }
	public Node getO1() {
		return o1;
	}
	public Node getO2() {
		return o2;
	}
}
