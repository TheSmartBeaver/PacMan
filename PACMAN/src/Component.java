import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import javax.swing.text.html.CSS;


public class Component {
    private boolean running = false;
    private static String windows_title = "PACMAN";
    private static int scale = 3; /*Car on aura pas besoin d'aussi grosse résolution ?? */
    private static int widdth = 720/scale;
    private static int height = 480/scale;

    DisplayMode mode = new DisplayMode(widdth*scale, height*scale);

    public Component(){
        try {


            Display.setDisplayMode(mode);
            Display.setResizable(true);
            Display.setFullscreen(false);
            Display.setTitle(windows_title);
            Display.create();
        }
        catch (LWJGLException e){
            e.printStackTrace();
        }
    }

    public void start(){
        running = true;
        loop();
    }

    public void stop(){
        running = false;
    }

    public void loop(){
        while (running == true){
        if(Display.isCloseRequested()) stop(); /*Si on appuie sur croix fermeture*/
        Display.update();
        }
    }

    public static void main(String args[]){
        Component main = new Component();
        main.start();
    }
}
