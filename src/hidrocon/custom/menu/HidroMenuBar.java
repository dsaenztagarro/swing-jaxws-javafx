/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.menu;

import hidrocon.custom.Constant;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Paint;
import javax.swing.JMenuBar;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroMenuBar extends JMenuBar {

	public final static int HORIZONTAL = 0;
	public final static int VERTICAL = 1;
	public final static int DIAGONAL_LEFT = 2;
	public final static int DIAGONAL_RIGHT = 3;

	private int direction = HORIZONTAL;
	private boolean cyclic;
	private int maxLength;


	public HidroMenuBar() {
		super();
		initProperties();
	}

	private void initProperties() {
		setOpaque(false);
		setPreferredSize(new Dimension(700,35));
		setFont(Constant.DEFAULT_FONT);
		setBorderPainted(false);
		//gradient settings
		setForeground(Constant.MENU_BAR_FOREGROUND);
		setBackground(Constant.MENU_BAR_BACKGROUND);
		setDirection(VERTICAL);
	}

	public HidroMenuBar(int direction )
	{
		super();
		setOpaque( false );
		this.direction = direction;
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
    if( isOpaque() )
    {
      super.paintComponent( g );
      return;
    }

    int width = getWidth();
    int height = getHeight();

    // Create the gradient paint
    GradientPaint paint = null;

    Color sc = getForeground();
    Color ec = getBackground();

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

}
