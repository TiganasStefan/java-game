package PAOO_GAME.States;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.RefLinks;

import java.awt.*;

public class MenuState extends State {

    private int counter=0;

    private int menuChoice=0;
    private String[] options =
            {
                    "Start",
                    "Controls",
                    "Quit"
            };


    private Color titleColor;
    private Color menuColor;
    private Font titleFont;

    private Font font;


    public MenuState(RefLinks refLink)
    {

        super(refLink);
        titleColor=new Color(3, 146, 28, 255);
        menuColor=new Color(212, 4, 4, 233);
        titleFont=new Font("Times New Roman",Font.PLAIN,36);

    }

    @Override
    public void Update() {
        if (counter==6)
        {
            getInput();
            counter=0;

        }
        counter++;

    }

    @Override
    public void Draw(Graphics g) {

        g.drawImage(Assets.background,0,0,null);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("FEED YOUR CHILDREN",350,120);
        g.setFont(font);
        for (int i=0;i<options.length;i++)
        {
            if (i==menuChoice)
            {
                g.setColor(titleColor);
            }
            else
            {
                g.setColor(menuColor);
            }
            g.drawString(options[i],450,180+i*40);
        }

    }

    private void select(){
        if(menuChoice == 0){
            refLink.GetGame().PlayState.resetState();
            State.SetState(refLink.GetGame().PlayState);
        }
        if(menuChoice == 1){
            State.SetState(refLink.GetGame().ControlsState);
        }

        if(menuChoice == 2){
            System.exit(0);
        }
    }

    private void getInput(){
        if(refLink.GetKeyManager().enter)
            select();


        if(refLink.GetKeyManager().up){
            menuChoice--;
            if(menuChoice == -1)
            {
                menuChoice = options.length-1;
            }
        }


        if(refLink.GetKeyManager().down){
            menuChoice++;
            if(menuChoice == options.length)
                menuChoice = 0;
        }
    }

    @Override
    public void resetState() {

    }
}
