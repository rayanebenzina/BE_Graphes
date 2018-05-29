package org.insa.algo;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.insa.algo.shortestpath.AStarAlgorithm;
import org.insa.algo.shortestpath.BellmanFordAlgorithm;
import org.insa.algo.shortestpath.DijkstraAlgorithm;
import org.insa.algo.shortestpath.ShortestPathAlgorithm;
import org.insa.algo.shortestpath.ShortestPathData;
import org.insa.algo.shortestpath.ShortestPathSolution;
import org.insa.graph.Graph;
import org.insa.graph.io.BinaryGraphReader;
import org.junit.BeforeClass;
import org.junit.Test;

public class PerformanceTest
{
	private static Graph carredense, fractalspiral, hautegaronne;

	@BeforeClass
	public static void initAll(){
		
		try
		{
			hautegaronne = (new BinaryGraphReader(new DataInputStream(new BufferedInputStream(new FileInputStream("haute-garonne.mapgr"))))).read();
			fractalspiral = (new BinaryGraphReader(new DataInputStream(new BufferedInputStream(new FileInputStream("fractal-spiral.mapgr"))))).read();
			carredense = (new BinaryGraphReader(new DataInputStream(new BufferedInputStream(new FileInputStream("carre-dense.mapgr"))))).read();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		

	}
	public static ShortestPathSolution result(ShortestPathAlgorithm algo)
	{
		return algo.run();
	}
	public static double averageduration(ShortestPathAlgorithm algo)
	{
		double begin = System.nanoTime();
		algo.run();
		double end = System.nanoTime();
		return (end-begin);
	}
	
	@Test
	public void hauteGaronneTest()
	{
		ArcInspector aI =ArcInspectorFactory.getAllFilters().get(0);
		ShortestPathData data = new ShortestPathData(hautegaronne, hautegaronne.get(6), hautegaronne.get(21), aI);
		double b = averageduration(new BellmanFordAlgorithm(data));
		double d = averageduration(new DijkstraAlgorithm(data));
		double a = averageduration(new AStarAlgorithm(data));
		assertTrue(true);
		System.out.println("Test haute garonne : " + b + " bellmanford, " + d + " dijkstra " + a + " Astar");
	}
	@Test
	public void carreDenseTest()// d'un coin à l'autre, A* bat tous les records
	{
		ArcInspector aI =ArcInspectorFactory.getAllFilters().get(0);
		ShortestPathData data = new ShortestPathData(carredense, carredense.get(321931), carredense.get(190456), aI);
		double b = averageduration(new BellmanFordAlgorithm(data));
		double d = averageduration(new DijkstraAlgorithm(data));
		double a = averageduration(new AStarAlgorithm(data));
		assertTrue(true);
		System.out.println("Test carre dense : " + b + " bellmanford, " + d + " dijkstra " + a + " Astar");
	}
	@Test
	public void fractalSpiralTest()// du centre à l'exterieur, BellmanFord gagne
	{
		ArcInspector aI =ArcInspectorFactory.getAllFilters().get(0);
		ShortestPathData data = new ShortestPathData(fractalspiral, fractalspiral.get(611565), fractalspiral.get(139116), aI);
		double b = averageduration(new BellmanFordAlgorithm(data));
		double d = averageduration(new DijkstraAlgorithm(data));
		double a = averageduration(new AStarAlgorithm(data));
		assertTrue(true);
		System.out.println("Test spirale fractale : " + b + " bellmanford, " + d + " dijkstra " + a + " Astar");
	}
	@Test
	public void fractalSpiralTest2()// de l'exterieur au centre, A* gagne
	{
		ArcInspector aI =ArcInspectorFactory.getAllFilters().get(0);
		ShortestPathData data = new ShortestPathData(fractalspiral, fractalspiral.get(139116), fractalspiral.get(611565), aI);
		double b = averageduration(new BellmanFordAlgorithm(data));
		double d = averageduration(new DijkstraAlgorithm(data));
		double a = averageduration(new AStarAlgorithm(data));
		assertTrue(true);
		System.out.println("Test spirale fractale : " + b + " bellmanford, " + d + " dijkstra " + a + " Astar");
	}
	

	// TODO

}