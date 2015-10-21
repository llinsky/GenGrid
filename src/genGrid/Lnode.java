
package genGrid;

import java.util.ArrayList;
import java.util.Random;

/**
 * This will be a single unit that, through connections in a NetGrid,
 * will create a network that can be simulated.
 * 
 * Properties: It has 3 input connections, that can be connected to
 * one data line, and 1 output connection. Two of the input connections
 * will be negative feedback lines, the other will be a positive
 * feedback line. There will also be randomness introduced.
 *
 */

public class Lnode {
	
	public Lnode(int [] inLoc1, int [] inLoc2, int [] inLoc3, double learnA, double learnB, double learnC)
	{
		inputA = inLoc1;
		inputB = inLoc2;
		inputC = inLoc3;
		cA = learnA;
		cB = learnB;
		cC = learnC;
		
		wA = 1.0;
		wB = -0.5;
		wC = -0.5;
		
		output = 1.0;
		
		randGen = new Random();
	}
	
	public Lnode(Lnode node)
	{
		inputA = node.getInputCoords(0);
		inputB = node.getInputCoords(1);
		inputC = node.getInputCoords(2);
		
		cA = node.getLearnConst(0);
		cB = node.getLearnConst(1);
		cC = node.getLearnConst(2);
		
		wA = node.getWeight(0);
		wB = node.getWeight(1);
		wC = node.getWeight(2);
		
		output = node.getLastOutput();
		
		randGen = new Random();
	}
	
	public void update(double inA, double inB, double inC)
	{
		outputFunction (inA,inB,inC);
		learningFunction(inA,inB,inC);
		return;
	}
	
	public void learningFunction(double inA, double inB, double inC)
	{
		wA *= (1+inA*cA);
		wB *= (1+inB*cB);
		wC *= (1+inC*cC);
	}
	
	public void outputFunction(double inA, double inB, double inC)
	{
		double rand = ((double)randGen.nextInt()%20)/100+0.9; //see what rand does
		
		if ((wA * inA + wB * inB + wC * inC)*rand <= -1)
		{
			output = -1;
		}
		else if ((wA * inA + wB * inB + wC * inC)*rand >= 1)
		{
			output = 1;
		}
		else
		{
			output = (wA * inA + wB * inB + wC * inC)*rand;
		}
		return;
	}
	
	public int[] getInputCoords(int index) //index 0 = A, 1 = B, 2 = C
	{
		if (index == 0)
		{
			return inputA;
		}
		else if (index == 1)
		{
			return inputB;
		}
		else
		{
			return inputC;
		}
	}
	
	public void setInputCoords(int index, int[] inCoord) //index 0 = A, 1 = B, 2 = C
	{
		if (index == 0)
		{
			inputA = inCoord;
		}
		else if (index == 1)
		{
			inputB = inCoord;
		}
		else
		{
			inputC = inCoord;
		}
	}
	
	public double getLearnConst(int index) //index 0 = A, 1 = B, 2 = C
	{
		if (index == 0)
		{
			return cA;
		}
		else if (index == 1)
		{
			return cB;
		}
		else
		{
			return cC;
		}
	}
	
	public double getWeight(int index) //index 0 = A, 1 = B, 2 = C
	{
		if (index == 0)
		{
			return wA;
		}
		else if (index == 1)
		{
			return wB;
		}
		else
		{
			return wC;
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
	
	
	private int [] inputA, inputB, inputC;
	private double wA, wB, wC; //weights associated with each input
	private double cA, cB, cC; //change (learning) rates for each input
	private double output;
	private Random randGen;
	
}
