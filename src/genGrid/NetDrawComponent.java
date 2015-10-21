package genGrid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class NetDrawComponent extends JComponent
{
    
    public NetDrawComponent(NetGrid newgrid, ImPoint start)
    {
    	grid = newgrid;
    	startPos = start;
    }
    
    public void paintComponent(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
    	ImPoint ImPointNew;
    	
    	int x = grid.getX();
    	int y = grid.getY();
	
    	for (int i = 0; i < x-1; i++)
		{
			for (int j = 0; j < y; j++)
			{
				ImPointNew = startPos.translate(i*50, j*50);
				g2.drawRect(ImPointNew.getX(), ImPointNew.getY(), 20, 20);
				
				Line2D.Double line = new Line2D.Double(ImPointNew.getPoint2D(),ImPointNew.translate(-5, 0).getPoint2D());
				g2.draw(line);
				
				line = new Line2D.Double(ImPointNew.translate(0, 10).getPoint2D(),ImPointNew.translate(-5, 10).getPoint2D());
				g2.draw(line);
				
				line = new Line2D.Double(ImPointNew.translate(0, 20).getPoint2D(),ImPointNew.translate(-5, 20).getPoint2D());
				g2.draw(line);
				
			}
		}
	
    }
	
    
    private ImPoint startPos;
    private NetGrid grid;
}
