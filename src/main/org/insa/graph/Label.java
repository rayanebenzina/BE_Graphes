package org.insa.graph;

public class Label implements Comparable<Label>{
	protected Arc pere;
	protected boolean mark;
	protected int id;
    protected double cost;
	protected double estimatedCost;
	
	public Label()
	{
		cost = Double.POSITIVE_INFINITY;
		pere = null;
		mark = false;
		id = 0;
		estimatedCost=0;
	}
	public double getTotalCost()
	{
		return this.cost + this.estimatedCost;
		
	}
	public Label(int id)
	{
		cost = Double.POSITIVE_INFINITY;
		pere = null;
		mark = false;
		this.id = id;
	}
	public boolean isMarked() {
		return mark;
	}
	public int getId()
	{
		return id;
	}
	public void Mark() {
			this.mark = true;
	}
	public Arc getPere() {
		return pere;
	}
	public void setPere(Arc pere) {
		this.pere = pere;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cout) {
		this.cost = cout;
	}
	public double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}	
	@Override
	public int compareTo(Label y) {
		int result =Double.compare(getTotalCost(), y.getTotalCost());
		return ( result != 0) ? result : Double.compare(estimatedCost, y.getEstimatedCost());
	}
}
