package org.insa.algo;

import static org.junit.Assert.assertTrue;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
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

public abstract class MapWithoutOracleTest
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
	public static double duration(ShortestPathAlgorithm algo)
	{
		ShortestPathSolution result = algo.run();
		return result.getSolvingTime().getSeconds();
	}


	// TODO

}