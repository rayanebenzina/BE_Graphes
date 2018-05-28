package org.insa.algo.MeetingPoint;

import java.awt.Color;

import org.insa.graph.Node;
import org.insa.graphics.drawing.Drawing;
import org.insa.graphics.drawing.overlays.PointSetOverlay;

public class MeetingPointGraphicObserver implements MeetingPointObserver{
	
	protected Drawing drawing;
    protected PointSetOverlay psOverlay1, psOverlay2,psOverlay3;
    
    public MeetingPointGraphicObserver(Drawing drawing) {
        this.drawing = drawing;
        psOverlay1 = drawing.createPointSetOverlay(1, Color.RED);
        psOverlay2 = drawing.createPointSetOverlay(1, Color.BLUE);
        psOverlay3 = drawing.createPointSetOverlay(1, Color.GREEN);
    }
    
	@Override
	public void notifyNodeInMiddle(Node node) {
		psOverlay1.addPoint(node.getPoint());
		
	}

	@Override
	public void notifyEqualCosts(Node node) {
		psOverlay2.addPoint(node.getPoint());
	}

	@Override
	public void notifyIsSolution(Node node) {
		psOverlay3.addPoint(node.getPoint());
	}

}
