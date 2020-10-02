package PAOO_GAME;

import PAOO_GAME.GameWindow.GameWindow;
import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.Input.KeyManager;
import PAOO_GAME.States.*;
import PAOO_GAME.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Singletone implements Runnable{


    private GameWindow window;
    private boolean runState;
    private Thread gameThread;
    private BufferStrategy bs;
    private Graphics g;


    public State PlayState;
    public State MenuState;
    public State ControlsState;
    public State GameOverState;
    public State WinState;

    private KeyManager keyManager;

    private RefLinks refLink;
    public int score = 0;

    private Tile tile;

    public Game (String title,int width,int height)
    {
        window=new GameWindow(title,width,height);
        runState=false;
        keyManager=new KeyManager();
    }

    private void InitGame()
    {
        window.BuildGameWindow();
        window.GetWindowFrame().addKeyListener(keyManager);
        Assets.Init();
        refLink=new RefLinks(this);
        PlayState=new PlayState(refLink);
        MenuState=new MenuState(refLink);
        ControlsState= new ControlsState(refLink);
        GameOverState=new GameOverState(refLink);
        WinState= new WinState(refLink);
        State.SetState(MenuState);
    }


    @Override
    public void run() {
        InitGame();
        long oldTime=System.nanoTime();
        long currentTime;
        final int framesPerSecond=60;
        final double timeFrame= 1000000000 / framesPerSecond;
        while (runState==true)
        {
            currentTime=System.nanoTime();
            if ((currentTime-oldTime) > timeFrame)
            {
                Update();
                Draw();
                oldTime=currentTime;
            }
        }
    }

    public synchronized  void StartGame()
    {
        if (runState==false)
        {
            runState=true;
            gameThread=new Thread(this );
            gameThread.start();
        }
        else
        {
            return;
        }

    }

    public synchronized void StopGame()
    {
        if (runState==true)
        {
            runState=false;
            try
            {

                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }

        }
        else
        {
            return;
        }
    }


    private void Update()
    {
        keyManager.Update();
        if (State.GetState()!=null)
        {
            State.GetState().Update();

        }
        System.out.println("Score:    " + score);

    }

    private void Draw()
    {
        bs=window.GetCanvas().getBufferStrategy();
        if (bs==null)
        {
            try
            {
                window.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
        }

        g=bs.getDrawGraphics();
        g.clearRect(0,0,window.GetWindowWidth(),window.GetWindowHeight());
        if (State.GetState()!=null)
        {
            State.GetState().Draw(g);
        }
        bs.show();
        g.dispose();
    }

    public static Game getInstace(String title,int width,int height)
    {
        if (instance==null)
            return new Game(title,width,height);
        return (Game)instance;
    }

    public int GetWidth()
    {
        return window.GetWindowWidth();
    }

    public int GetHeight()
    {
        return window.GetWindowHeight();
    }

    public KeyManager GetKeyManager()
    {
        return keyManager;
    }



}
