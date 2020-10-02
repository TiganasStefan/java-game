package PAOO_GAME.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean enter;
    public boolean esc;


    public KeyManager()
    {
        keys=new boolean[256];
    }

    public void Update()
    {
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];
        enter=keys[KeyEvent.VK_ENTER];
        esc=keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyPressed(KeyEvent e) {

        keys[e.getKeyCode()]=true;

    }

    @Override
    public void keyReleased(KeyEvent e) {

        keys[e.getKeyCode()]=false;

    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
