/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author david
 */
public class Constant {

    public static final int ENTITY_MANAGEMENT_MODE_DEFAULT = 0;
    public static final int VIEW_MODE_CREATION = 1;
    public static final int VIEW_MODE_READONLY = 2;
    public static final int VIEW_MODE_UPDATE = 3;
    public static final int ENTITY_MANAGEMENT_MODE_SUMMARY = 4;
    public static final int ENTITY_MANAGEMENT_MODE_SELECTION = 5;
        
    public static String TRUE = "T";
    public static String FALSE = "F";
    public static String YES = "Y";
    public static String NO = "N";
    
	public static char CHARACTER_TRUE = 'T';
	public static char CHARACTER_FALSE = 'F';
	public static char CHARACTER_YES = 'Y';
	public static char CHARACTER_NO = 'N';
    
	public static char RECORD_STATUS_DELETE = 'D';
	public static char RECORD_STATUS_ACTIVE = 'A';

	public static final Color TABLE_HEADER_BACKGROUND = new Color(56,53,53);
	public static final int TABLE_ROW_HEIGHT = 28;
    public static final int TABLE_DETAIL_ROW_HEIGHT = 24;
    
	public static final Color TEXTFIELD_BACKGROUND_NOT_EDITABLE = new Color(203,212,225);
	public static final Color TEXTFIELD_BACKGROUND_FOCUS_LOST = new Color(170,183,203);
	public static final Color TEXTFIELD_BACKGROUND_FOCUS_GAINED = new Color(118,135,162);
    public static final Color TEXTFIELD_SELECTION_BACKGROUND = new Color(58,78,109);
    public static final Color TEXTFIELD_SELECTION_FOREGROUND = Color.WHITE;
	public static final Color APPLICATION_BACKGROUND = Color.WHITE;
	public static final Font TEXTFIELD_DEFAULT_FONT = new Font("Arial",Font.PLAIN,14);
    public static final Font DEFAULT_FONT = new Font("Arial",Font.BOLD,12);
    public static final Font SMALL_FONT = new Font("Arial",Font.BOLD,10);
	public static final Font TITLE_FONT = new Font("Arial",Font.BOLD,16);

	public static final int TOP_PANEL_HEIGHT = 40;
	public static final int LEFT_RIGHT_PANEL_WIDTH = 25;
	public static final int BOTTOM_PANEL_HEIGHT = 30;

	public static final Color TEXTFIELD_BORDER_COLOR = new Color(56,53,53);
	public static final Color LABEL_FOREGROUND = new Color(11,0,49);
    public static final Color LABEL_FOREGROUND_OFF = new Color(104,104,104);

	public static final Color MENU_BAR_FOREGROUND = new Color(11,0,49); // Color(1,15,85);
	public static final Color MENU_BAR_BACKGROUND = new Color(25,0,118); //5,32,171);

	public static final Color TOP_PANEL_FOREGROUND = new Color(0,42,116); // Color(1,15,85);
	public static final Color TOP_PANEL_BACKGROUND = new Color(1,90,225); //5,32,171);
    
	public static final Color MAIN_PANEL_BACKGROUND = new Color(216,224,234); //103,106,119); // Color(1,15,85);

	public static final Color SECTION_PANEL_FOREGROUND = new Color(61,61,61); //88,88,88); //new Color(61,71,48); //Color(6,49,0);
	public static final Color SECTION_PANEL_BACKGROUND = new Color(116,121,109); //107,114,98); //151,157,143); //107,114,98); //Color(47,97,40);
	public static final Color ITEM_PANEL_FOREGROUND = new Color(23,33,41); //88,88,88); //new Color(61,71,48); //Color(6,49,0);
	public static final Color ITEM_PANEL_BACKGROUND = new Color(65,85,100); //107,114,98); //151,157,143); //107,114,98); //Color(47,97,40);
	public static final Color ITEM_CONTENT_PANEL_FOREGROUND = new Color(121,133,143);
	public static final Color ITEM_CONTENT_PANEL_BACKGROUND = new Color(172,178,183);
	public static final Color ITEM_CONTENT_PANEL_FOREGROUND_OVER = new Color(85,85,85);
	public static final Color ITEM_CONTENT_PANEL_BACKGROUND_OVER = new Color(133,136,138);
	public static final Color ITEM_CONTENT_PANEL_FOREGROUND_OFF = new Color(169,169,169);
	public static final Color ITEM_CONTENT_PANEL_BACKGROUND_OFF = new Color(193,193,193);
    
	public static final Color ITEM_CONTAINER_PANEL_FOREGROUND = new Color(192,200,207);
	public static final Color ITEM_CONTAINER_PANEL_BACKGROUND = new Color(138,178,210);
    
	public static final int BORDER_VERTICAL = 20;
	public static final int BORDER_HORIZONTAL = 20;

    public static final int MOVE_UP = 1;
    public static final int MOVE_DOWN = 2;    
}
