package genGrid;

import java.util.Random;

//just a comparator basically

public class Onode {
	
	public Onode(int [] inLoc1, int [] inLoc2)
	{
		inputA = inLoc1;
		inputB = inLoc2;
		
		output = 0.0;
	}

	public void update(double inA, double inB, double inC)
	{
		outputFunction (inA,inB,inC);
		return;
	}
	
	public void outputFunction(double inA, double inB, double inC)
	{
		if ((inA + inB) < -0.25)
		{
			output = -1;
		}
		else if ((inA + inB) > 0.25)
		{
			output = 1;
		}
		else
		{
			output = 0.0;
		}
		return;
	}
	
	public void setInputCoords(int index, int[] inCoord) //index 0 = A, 1 = B, 2 = C
	{
		if (index == 0)
		{
			inputA = inCoord;
		}
		else
		{
			inputB = inCoord;
		}
	}
	
	public double getLastOutput()
	{
		return output;
	}
	public void setLastOutput(double _output)
	{
		output = _output;
	}
	
	public int[] getInputCoords(int index) //index 0 = A, 1 = B, 2 = C
	{
		if (index == 0)
		{
			return inputA;
		}
		else
		{
			return inputB;
		}
	}
	
	private int [] inputA, inputB;
	private double output;
}
