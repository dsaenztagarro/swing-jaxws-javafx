/*
 * HidroconApp.java
 */

package hidrocon;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class HidroconApp extends SingleFrameApplication {
    
    HidroconView hidroconView;
    HidroconModel hidroconModel;
    HidroconController hidroconController;
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        hidroconView = new HidroconView(this);
        hidroconModel = new HidroconModel();
        hidroconController = new HidroconController(hidroconView, hidroconModel);
        show(hidroconView);
    }
    
    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of HidroconApp
     */
    public static HidroconApp getApplication() {
        return Application.getInstance(HidroconApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(HidroconApp.class, args);
        
    }
    
    
}
