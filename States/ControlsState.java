package PAOO_GAME.States;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.RefLinks;

import java.awt.*;

public class ControlsState extends State {

    private String[] commands=
            {
                    "Move Left        KEY_LEFT",
                    "Move Right      KEY_RIGHT",
                    "Jump                KEY_UP",
                    "Exit                  ESC"
            };


    public ControlsState(RefLinks refLink)
    {
        super(refLink);

    }

    @Override
    public void Update() {
        getInput();
    }

    @Override
    public void Draw(Graphics g) {

        g.drawImage(Assets.background,0,0,null);

        g.setColor(new Color(3, 146, 28, 255));
        g.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        g.drawString("CONTROLS:", 390, 100);


        g.setColor(new Color(212, 4, 4, 233));
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        for(int i = 0; i < commands.length; i++) {
            g.drawString(commands[i], 360, 160 + i * 30);
        }

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
