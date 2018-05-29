package org.insa.algo;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import org.insa.algo.ArcInspector;
import org.insa.algo.shortestpath.BellmanFordAlgorithm;
import org.insa.algo.shortestpath.DijkstraAlgorithm;
import org.insa.algo.shortestpath.ShortestPathAlgorithm;
import org.insa.algo.shortestpath.ShortestPathData;
import org.insa.algo.shortestpath.ShortestPathSolution;
import org.insa.graph.Graph;
import org.insa.graph.Node;
import org.insa.graph.RoadInformation;
import org.insa.graph.RoadInformation.RoadType;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleGraphTest{
	
	private static Graph graph;
	private static Node[] nodes ;
	private static ArrayList<ShortestPathSolution> bResults,dResults;
	
	@BeforeClass
	public static void initAll(){
		
		RoadInformation rI = new RoadInformation(RoadType.MOTORWAY, null, true, 1, "");
		bResults = new ArrayList<ShortestPathSolution>();
		dResults = new ArrayList<ShortestPathSolution>();
		
		nodes = new Node[6];
		for (int i = 0; i < nodes.length; ++i) {
			nodes[i] = new Node(i, null);
		}
		Node.linkNodes(nodes[0], nodes[1], 7, rI, null);
		Node.linkNodes(nodes[0], nodes[2], 8, rI, null);
		Node.linkNodes(nodes[1], nodes[3], 4, rI, null);
		Node.linkNodes(nodes[1], nodes[4], 1, rI, null);
		Node.linkNodes(nodes[1], nodes[5], 5, rI, null);
		Node.linkNodes(nodes[2], nodes[0], 7, rI, null);
		Node.linkNodes(nodes[2], nodes[1], 2, rI, null);
		Node.linkNodes(nodes[2], nodes[5], 2, rI, null);
		Node.linkNodes(nodes[4], nodes[3], 2, rI, null);
		Node.linkNodes(nodes[4], nodes[3], 2, rI, null);
		Node.linkNodes(nodes[4], nodes[5], 3, rI, null);
		Node.linkNodes(nodes[5], nodes[4], 3, rI, null);
		graph = new Graph("ID", "", Arrays.asList(nodes), null);
		
		runAllNodes();

	}

	public static ShortestPathSolution result(ShortestPathAlgorithm algo)
	{
		return algo.run();
	}
	
	public static void runAllNodes()
	{
		ArcInspector aI = ArcInspectorFactory.getAllFilters().get(0); 
		for (Node i : nodes) {
			for (Node j : nodes) {
				ShortestPathData data  = new ShortestPathData(graph, i, j, aI);
				dResults.add(result(new DijkstraAlgorithm(data)));
				bResults.add(result(new BellmanFordAlgorithm(data))); 
			    
			}
		}
	}
	@Test
	public void testSimpleGraph()
	{
		for (int i = 0; i<bResults.size();i++)
		{
				ShortestPathSolution b = bResults.get(i);
				ShortestPathSolution d = dResults.get(i);
				assertTrue(b.equals(d));
		}
	}
}