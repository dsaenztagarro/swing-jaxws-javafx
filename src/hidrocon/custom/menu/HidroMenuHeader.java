/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.menu;
import javax.swing.JMenu;

import hidrocon.custom.Constant;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Paint;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroMenuHeader extends JMenu {


	public final static int HORIZONTAL = 0;
	public final static int VERTICAL = 1;
	public final static int DIAGONAL_LEFT = 2;
	public final static int DIAGONAL_RIGHT = 3;

	private int direction = HORIZONTAL;
	private boolean cyclic;
	private int maxLength;

	public HidroMenuHeader() {
		super();
		initProperties();
	}

	private void initProperties() {
		setFont(Constant.DEFAULT_FONT);
		setForeground(Color.WHITE);
		setDirection(VERTICAL);
	}

  // --------------------- GETTER / SETTER METHODS ---------------------

  public int getDirection()
  {
    return direction;
  }

  public void setDirection( int direction )
  {
    this.direction = direction;
  }

  public boolean isCyclic()
  {
    return cyclic;
  }

  public void setCyclic( boolean cyclic )
  {
    this.cyclic = cyclic;
  }

  public void setMaxLength( int maxLength )
  {
    this.maxLength = maxLength;
  }

  // -------------------------- OTHER METHODS --------------------------

  public void paintComponent( Graphics g )
  {
    /*if( isOpaque() )
    {
      super.paintComponent( g );
      return;
    }*/

		int width = getWidth();
		int height = getHeight();

		// Create the gradient paint
		GradientPaint paint = null;

		Color sc = Constant.MENU_BAR_FOREGROUND;
		Color ec = Constant.MENU_BAR_BACKGROUND;
		//System.out.println("sc: " + sc.toString());
		//System.out.println("ec: " + ec.toString());

		switch( direction )
		{
		case HORIZONTAL :
		{
		  paint = new GradientPaint( 0, height / 2, sc, width, height / 2, ec, cyclic );
		  break;
		}
		case VERTICAL :
		{
		  paint = new GradientPaint( width / 2, 0, sc, width / 2, maxLength > 0 ? maxLength : height, ec, cyclic );
		  break;
		}
		case DIAGONAL_LEFT :
		{
		  paint = new GradientPaint( 0, 0, sc, width, height, ec, cyclic );
		  break;
		}
		case DIAGONAL_RIGHT :
		{
		  paint = new GradientPaint( width, 0, sc, 0, height, ec, cyclic );
		  break;
		}
		}

		if( paint == null )
		{
		  throw new RuntimeException( "Invalid direction specified in GradientPanel" );
		}

		// we need to cast to Graphics2D for this operation
		Graphics2D g2d = ( Graphics2D )g;

		// save the old paint
		Paint oldPaint = g2d.getPaint();

		// set the paint to use for this operation
		g2d.setPaint( paint );

		// fill the background using the paint
		g2d.fillRect( 0, 0, width, height );

		// restore the original paint
		g2d.setPaint( oldPaint );

	super.paintComponent( g );
  }


  public void paintChildren( Graphics g )
  {
    /*if( isOpaque() )
    {
      super.paintComponent( g );
      return;
    }*/
	if (isSelected()) {
		int width = getWidth();
		int height = getHeight();

		// Create the gradient paint
		GradientPaint paint = null;

		Color sc = Constant.MENU_BAR_BACKGROUND;
		Color ec = Constant.MENU_BAR_FOREGROUND;
		//System.out.println("sc: " + sc.toString());
		//System.out.println("ec: " + ec.toString());

		switch( direction )
		{
		case HORIZONTAL :
		{
		  paint = new GradientPaint( 0, height / 2, sc, width, height / 2, ec, cyclic );
		  break;
		}
		case VERTICAL :
		{
		  paint = new GradientPaint( width / 2, 0, sc, width / 2, maxLength > 0 ? maxLength : height, ec, cyclic );
		  break;
		}
		case DIAGONAL_LEFT :
		{
		  paint = new GradientPaint( 0, 0, sc, width, height, ec, cyclic );
		  break;
		}
		case DIAGONAL_RIGHT :
		{
		  paint = new GradientPaint( width, 0, sc, 0, height, ec, cyclic );
		  break;
		}
		}

		if( paint == null )
		{
		  throw new RuntimeException( "Invalid direction specified in GradientPanel" );
		}

		// we need to cast to Graphics2D for this operation
		Graphics2D g2d = ( Graphics2D )g;

		// save the old paint
		Paint oldPaint = g2d.getPaint();

		// set the paint to use for this operation
		g2d.setPaint( paint );

		// fill the background using the paint
		g2d.fillRect( 0, 0, width, height );


		/*FontMetrics fm = g2d.getFontMetrics();
		int fontHeight = fm.getAscent() + fm.getDescent();
		g2d.setColor(Color.WHITE);

		float y = getHeight() - ((getHeight() - fontHeight)/2);
		g2d.set*/
		g2d.setColor(Color.WHITE);
		g2d.drawString(getText(), 6, 21);


		// restore the original paint
		g2d.setPaint( oldPaint );

	}
	super.paintChildren( g );
  }

}
