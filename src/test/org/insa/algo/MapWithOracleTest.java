package org.insa.algo;

import static org.junit.Assert.assertTrue;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.insa.algo.ArcInspector;
import org.insa.algo.shortestpath.BellmanFordAlgorithm;
import org.insa.algo.shortestpath.DijkstraAlgorithm;
import org.insa.algo.shortestpath.ShortestPathAlgorithm;
import org.insa.algo.shortestpath.AStarAlgorithm;
import org.insa.algo.shortestpath.ShortestPathData;
import org.insa.algo.shortestpath.ShortestPathSolution;
import org.insa.graph.Graph;
import org.insa.graph.io.BinaryGraphReader;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapWithOracleTest {
	private static Graph graph;

	@BeforeClass
	public static void initAll(){
		
		try
		{
			graph = (new BinaryGraphReader(
					new DataInputStream(new BufferedInputStream(new FileInputStream("haute-garonne.mapgr"))))).read();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	public static ShortestPathSolution result(ShortestPathAlgorithm algo)
	{
		return algo.run();
	}
	public static double duration(ShortestPathAlgorithm algo)
	{
		ShortestPathSolution result = algo.run();
		return result.getSolvingTime().getSeconds();
	}


	// Rester sur place, le plus court
	@Test
	public void onPlaceShortestTest() throws IOException{

		ArcInspector aI = ArcInspectorFactory.getAllFilters().get(0);

		ShortestPathData data = new ShortestPathData(graph, graph.get(8128), graph.get(8128), aI);
		ShortestPathSolution b = result(new BellmanFordAlgorithm(data));
		assertTrue(b.equals(result(new DijkstraAlgorithm(data))));
		assertTrue(b.equals(result(new AStarAlgorithm(data))));

	}

	// A pieds, le plus court
	@Test
	public void shortestWithLegsTest() throws IOException{

		ArcInspector aI = ArcInspectorFactory.getAllFilters().get(3);
		ShortestPathData data = new ShortestPathData(graph, graph.get(8128), graph.get(4132), aI);
		ShortestPathSolution b = result(new BellmanFordAlgorithm(data));
		assertTrue(b.equals(result(new DijkstraAlgorithm(data))));
		assertTrue(b.equals(result(new AStarAlgorithm(data))));

	}
	
	/* pedestrian en temps */
	@Test
	public void fastestWithLegsTest() throws IOException{	

		ArcInspector aI =ArcInspectorFactory.getAllFilters().get(3);
		ShortestPathData data = new ShortestPathData(graph, graph.get(8128), graph.get(4132), aI);
		ShortestPathSolution b = result(new BellmanFordAlgorithm(data));
		assertTrue(b.equals(result(new DijkstraAlgorithm(data))));
		assertTrue(b.equals(result(new AStarAlgorithm(data))));

	}

}