package genGrid;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
import java.lang.String;

import java.awt.Graphics; //for the print network function
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class GridMain {

	
	public static void main(String args[])
	{
		Random randGen = new Random();
		NetGrid grid;
		Scanner inputScanner = new Scanner(System.in);
		double output = 0;
		
		grid = createTestGrid1(randGen);
		//grid = createTestGrid2(randGen);
		
		double in1 = 1;
		double in2 = 1;
		double in3 = 0;
		
		boolean go = true;
		
		while (go)
		{
			for (int i = 0; i < 100; i++)
			{
				in1 = randGen.nextInt()%5;
				in2 = randGen.nextInt()%5;
				
				updateInputs(grid,in1,in2,in3);
				grid = updateGrid(grid);
				output = grid.getNode(8, 1).getLastOutput();
				
				in3 = RealSystem.giveFeedback(in1,in2,output);
				
				System.out.println("Output " + i + ": " + output);
			}
			
			System.out.println("Done");
			
			
			System.out.print("Type 'c' to update i more times. >> ");
			String cmd = inputScanner.nextLine();
			
			
			if (!cmd.equalsIgnoreCase("c"))
			{
				go = false;
			}
		}
		System.out.println("\nProgram terminated");
		
	}
	
	public static NetGrid createTestGrid1(Random randGen)
	{
		NetGrid gridTemp = new NetGrid(50,3);
		
		/*			Grid Design
		 *  	I	L	L	L	L	-
		 * 		I	L	L	L	L	O
		 * 		F 	L	L	L	L	-
		 */
		boolean in1Connected = false;
		boolean in2Connected = false;
		boolean in3Connected = false; //feedback
		
		for (int i = 1; i < 49; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				int [] inLoc1 = new int [2];
				inLoc1[0] = Math.abs(randGen.nextInt())%4;
				inLoc1[1] = Math.abs(randGen.nextInt())%3;
				
				int [] inLoc2 = new int [2];
				inLoc2[0] = Math.abs(randGen.nextInt())%4;
				inLoc2[1] = Math.abs(randGen.nextInt())%3;
				
				int [] inLoc3 = new int [2];
				inLoc3[0] = Math.abs(randGen.nextInt())%4;
				inLoc3[1] = Math.abs(randGen.nextInt())%3;
				
				
				if (((inLoc1[0]==0)&&(inLoc1[1]==0)) || ((inLoc2[0]==0)&&(inLoc2[1]==0)) || ((inLoc3[0]==0)&&(inLoc3[1]==0)))
				{
					in1Connected = true;
				}
				if (((inLoc1[0]==0)&&(inLoc1[1]==1)) || ((inLoc2[0]==0)&&(inLoc2[1]==1)) || ((inLoc3[0]==0)&&(inLoc3[1]==1)))
				{
					in2Connected = true;
				}
				if (((inLoc1[0]==0)&&(inLoc1[1]==2)) || ((inLoc2[0]==0)&&(inLoc2[1]==2)) || ((inLoc3[0]==0)&&(inLoc3[1]==2)))
				{
					in3Connected = true;
				}
				
				Lnode tempNode = new Lnode(inLoc1,inLoc2,inLoc3,0.01,0.01,0.01);
				gridTemp.add(i, j, tempNode);
			}
		}
		
		if (!in1Connected)
		{
			int [] array = new int [2];
			array[0] = 0;
			array[1] = 0;
			
			gridTemp.getNode(1, 0).setInputCoords(0, array);
		}
		if (!in2Connected)
		{
			int [] array = new int [2];
			array[0] = 0;
			array[1] = 1;
			
			gridTemp.getNode(1, 1).setInputCoords(0, array);
		}
		if (!in3Connected)
		{
			int [] array = new int [2];
			array[0] = 0;
			array[1] = 2;
			
			gridTemp.getNode(1, 2).setInputCoords(0, array);
		}
		
		int [] loc1 = new int [2];
		loc1[0] = 0; loc1[1] = 0;
		Lnode in1 = new Lnode(loc1,loc1,loc1,0,0,0);
		in1.setLastOutput(1);
		gridTemp.add(0, 0, in1);
		
		int [] loc2 = new int [2];
		loc2[0] = 0; loc2[1] = 1;
		Lnode in2 = new Lnode(loc2,loc2,loc2,0,0,0);
		in2.setLastOutput(2);
		gridTemp.add(0, 1, in2);
		
		int [] loc3 = new int [2];
		loc3[0] = 0; loc3[1] = 2;
		Lnode in3 = new Lnode(loc3,loc3,loc3,0,0,0);
		in3.setLastOutput(0);
		gridTemp.add(0, 2, in3);
		

		//printMap(gridTemp);
		
		return gridTemp;
	}
	
	public static NetGrid createTestGrid2(Random randGen)
	{

		NetGrid gridTemp = new NetGrid(6,9);

		int [] loc = new int [2];
		loc[0] = 0; 
		for (int i = 0; i < 9; i++)
		{
			loc[1] = i;
			Lnode temp = new Lnode(loc,loc,loc,0,0,0);
			temp.setLastOutput(0);
			gridTemp.add(0,i,temp);
		}
		
		int [] loc1 = new int [2];
		loc1[1] = 0; loc1[1] = 0;
		
		int [] loc2 = new int [2];
		loc2[0] = 0; loc2[1] = 1;
		
		int [] loc3 = new int [2];
		loc3[0] = 0; loc3[1] = 2;
		
		int [] loc4 = new int [2];
		loc4[0] = 0; loc4[1] = 3;
		
		int [] loc5 = new int [2];
		loc5[0] = 0; loc5[1] = 4;
		
		int [] loc6 = new int [2];
		loc6[0] = 0; loc6[1] = 5;
		
		int [] loc7 = new int [2];
		loc7[0] = 0; loc7[1] = 6;
		
		int [] loc8 = new int [2];
		loc8[0] = 0; loc8[1] = 7;
		
		int [] loc9 = new int [2];
		loc9[0] = 0; loc9[1] = 8;
		
		
		Lnode temp = new Lnode(loc1,loc5,loc7,0.05,0.05,0.05);
		temp.setLastOutput(0);
		gridTemp.add(1,0,temp);
		
		temp = new Lnode(loc3,loc4,loc7,0.05,0.05,0.05);
		temp.setLastOutput(0);
		gridTemp.add(1,1,temp);
		
		temp = new Lnode(loc6,loc2,loc5,0.05,0.05,0.05);
		temp.setLastOutput(0);
		gridTemp.add(1,2,temp);
		
		temp = new Lnode(loc8,loc2,loc4,0.05,0.05,0.05);
		temp.setLastOutput(0);
		gridTemp.add(1,3,temp);
		
		loc[0] = 1;
		loc[1] = 4;
		temp = new Lnode(loc9,loc1,loc,0.1,0,0.1);
		temp.setLastOutput(0);
		gridTemp.add(1,4,temp);
		
		for (int j = 5; j < 9; j++)
		{
			int [] inLoc1 = new int [2];
			inLoc1[0] = Math.abs(randGen.nextInt())%6;
			inLoc1[1] = Math.abs(randGen.nextInt())%9;
			
			int [] inLoc2 = new int [2];
			inLoc2[0] = Math.abs(randGen.nextInt())%6;
			inLoc2[1] = Math.abs(randGen.nextInt())%9;
			
			int [] inLoc3 = new int [2];
			inLoc3[0] = Math.abs(randGen.nextInt())%6;
			inLoc3[1] = Math.abs(randGen.nextInt())%9;
			
			Lnode tempNode = new Lnode(inLoc1,inLoc2,inLoc3,0.1,0.1,0.1);
			gridTemp.add(1, j, tempNode);
		}
		
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				int [] inLoc1 = new int [2];
				inLoc1[0] = Math.abs(randGen.nextInt())%6;
				inLoc1[1] = Math.abs(randGen.nextInt())%9;
				
				int [] inLoc2 = new int [2];
				inLoc2[0] = Math.abs(randGen.nextInt())%6;
				inLoc2[1] = Math.abs(randGen.nextInt())%9;
				
				int [] inLoc3 = new int [2];
				inLoc3[0] = Math.abs(randGen.nextInt())%6;
				inLoc3[1] = Math.abs(randGen.nextInt())%9;
				
				Lnode tempNode = new Lnode(inLoc1,inLoc2,inLoc3,0.1,0.1,0.1);
				gridTemp.add(1, j, tempNode);
			}
		}
		
		return gridTemp;
	}
	
	public static NetGrid updateGrid (NetGrid grid)
	{
		NetGrid nextGrid = new NetGrid(grid.getX(),grid.getY());
		
		
		for (int i = 1; i < grid.getX()-1; i++) //for every Lnode, evaluate its next output based on old grid outputs
		{
			for (int j = 0; j < grid.getY(); j++)
			{
				int [] tempLocA,tempLocB,tempLocC;
				double inA, inB, inC;
				Lnode temp = new Lnode(grid.getNode(i,j));
				
				tempLocA = temp.getInputCoords(0);
				inA = grid.getNode(tempLocA[0], tempLocA[1]).getLastOutput();
				
				tempLocB = temp.getInputCoords(1);
				inB = grid.getNode(tempLocB[0], tempLocB[1]).getLastOutput();
				
				tempLocC = temp.getInputCoords(2);
				inC = grid.getNode(tempLocC[0], tempLocC[1]).getLastOutput();
				
				temp.update(inA, inB, inC);
				nextGrid.add(i, j, temp);
			}
		}
		
		for (int j = 0; j < grid.getY(); j++)
		{
			Lnode temp = new Lnode(grid.getNode(0,j));
			nextGrid.add(0, j, temp);
		}
		
		
		return nextGrid;
	}
	
	public static void updateInputs(NetGrid grid, double in1, double in2, double in3)
	{
		grid.getNode(0, 0).setLastOutput(in1);
		grid.getNode(0, 1).setLastOutput(in2);
		grid.getNode(0, 2).setLastOutput(in2);
	}
	
	
	public static void printMap(NetGrid grid)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setTitle("Node Grid");
		
		ImPoint startPos = new ImPoint(20,20);
		
		NetDrawComponent component = new NetDrawComponent(grid, startPos);
		frame.add(component);
		frame.setVisible(true);
		
	}
	
	
	
}
