package PAOO_GAME.GameWindow;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private JFrame windowFrame;
    private String windowTitle;
    private int windowWidth;
    private int windowHeight;

    private Canvas canvas;

    public GameWindow(String windowTitle,int windowWidth,int windowHeight)
    {
        this.windowTitle=windowTitle;
        this.windowWidth=windowWidth;
        this.windowHeight=windowHeight;
        this.windowFrame=null;
    }

    public void BuildGameWindow()
    {
        if (windowFrame!=null)
        {
            return;
        }
        windowFrame=new JFrame(windowTitle);
        windowFrame.setSize(windowWidth,windowHeight);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setResizable(false);
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setVisible(true);
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(windowWidth,windowHeight));
        canvas.setMaximumSize(new Dimension(windowWidth,windowHeight));
        canvas.setMinimumSize(new Dimension(windowWidth,windowHeight));
        windowFrame.add(canvas);
        windowFrame.pack();

    }

    public int GetWindowWidth()
    {
        return windowWidth;

    }
    public int GetWindowHeight()
    {
        return windowHeight;

    }
    public Canvas GetCanvas()
    {
        return canvas;
    }

    public JFrame GetWindowFrame()
    {
        return windowFrame;
    }


}
