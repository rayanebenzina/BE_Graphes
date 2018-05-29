package org.insa.algo.MeetingPoint;
import org.insa.algo.AbstractAlgorithm;
import org.insa.algo.AbstractInputData;

public abstract class MeetingPointAlgorithm extends AbstractAlgorithm<MeetingPointObserver> {
	
	protected MeetingPointAlgorithm(AbstractInputData data) {
		super(data);
	}
	@Override
	public MeetingPointSolution run() {
		return (MeetingPointSolution)super.run();
	}
	@Override
	protected abstract MeetingPointSolution doRun();
	@Override
	public MeetingPointData getInputData()
	{
		return (MeetingPointData) super.getInputData();
	}

}
