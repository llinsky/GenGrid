package genGrid;
import java.lang.Math;

/*
 * Takes the final outputs of the network and produces inputs to the network. This is
 * used to train the network toward ideal behavior. It will have one set of inputs that
 * represents some real system, and one input that represents how good the current output
 * is --e.g. provides negative feedback if the solution is not good enough
 */
public class RealSystem {
	
	/*Let's first design our system to be a function: f(x) = x^2 + 4xy + 3y - 1
	 * 
	 * We will input x and y, and the output will be f(x)
	 */
	
	public static double giveFeedback(double inX, double inY, double testOutput)
	{
		double desiredOutput = evaluateFunction(inX,inY);
		double feedback = (testOutput - desiredOutput)/testOutput;
		return feedback;
	}
	
	public static double evaluateFunction(double inX, double inY)
	{
		double output =  Math.pow(inX,2) - 2*inY;
		return output;
	}
	
	
}