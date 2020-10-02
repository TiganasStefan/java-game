package PAOO_GAME.States;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.RefLinks;

import java.awt.*;

public class WinState extends State {

    public WinState(RefLinks refLink)
    {
        super(refLink);
    }

    @Override
    public void Update() {
        getInput();
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.win,0,0,null);
    }


    private void getInput(){
        if(refLink.GetKeyManager().esc == true){
            State.SetState(refLink.GetGame().MenuState);
        }
    }

    @Override
    public void resetState() {

    }
}
