package genGrid;

import java.util.ArrayList;;


public class NetGrid {
	
	public NetGrid(int x, int y)
	{
		xSize = x; //x = 0 has inputs, x = x has outputs
		ySize = y;
		grid = new Lnode [xSize][ySize];
		
	}
	
	public int getX()
	{
		return xSize;
	}
	public int getY()
	{
		return ySize;
	}
	
	public Lnode getNode(int x, int y)
	{
		return grid[x][y];
	}
	
	public void add(int xCoord, int yCoord, Lnode node)
	{
		//assert ((xCoord > 0) && (xCoord < xSize - 1));
		grid[xCoord][yCoord] = new Lnode(node);
	}
	
	
	private int xSize;
	private int ySize;
	private Lnode [][] grid;
	
	
}
