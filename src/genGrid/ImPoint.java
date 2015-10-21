package genGrid;


import java.awt.geom.Point2D;


class ImPoint {

    /**
       Creatse the point with coordinates (x,y)
     */
    public ImPoint(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
       Returns the an ImPoint with coordinates translated by deltaX
       and deltaY from this point.
    */
    public ImPoint translate(int deltaX, int deltaY) {
	return new ImPoint(x + deltaX, y + deltaY);
    }

    /**
       Returns a String version of the Point for debugging purposes.

       In Java toString is a special function.  You are allowed to do
       a call like the following, and toString will get automatically
       called to do the conversion:

           System.out.println(myImPoint);

    */
    public String toString() {
	return "ImPoint[" + x + "," + y + "]";
    }

    /*
     *  Retursn a Point2D with same coordinates as this point
     *
     */
    public Point2D getPoint2D() {
	return new Point2D.Double(x, y);
    }

    /*
     * Returns the x-coordinate of the point.
     */
    public int getX() {
	return x;
    }

    /*
     * Returns the y-coordinate of the point.
     */
    public int getY() {
	return y;
    }



    private int x;
    private int y;
}

	
