package PAOO_GAME.Items;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.Maps.Map;
import PAOO_GAME.RefLinks;

import java.awt.*;

public class Mushroom extends Character {

    private int x0;
    private int x1;

    private boolean right = true;
    private boolean left  = false;

    private int contor = 0;

    public Mushroom(RefLinks refLink, float x, float y, int move){
        super(refLink,x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        x1 = (int)x+move;
        x0 = (int)x;
    }

    @Override
    public void Update(){

        if(right==true)
            if(x+2<x1)
                x=x+2;
            else
            {
                contor=0;
                right=false;
                left = true;
            }
        if(left==true){
            if(x-2>x0)
                x=x-2;
            else{
                contor=0;
                left = false;
                right = true;
            }
        }
        contor++;
        if(contor>35)
            contor = 0;
    }

    @Override
    public void Draw(Graphics g){



        if(onScreen()){
            if(right == true)
                g.drawImage(Assets.mushroomBack[contor/4],(int) x - Map.offset,(int) y,width,height,null);
            if(left == true)
                g.drawImage(Assets.mushroom[contor/4],(int) x - Map.offset,(int) y,width,height,null);
        }
    }

    public boolean onScreen(){
        if(x - Map.offset < refLink.GetGame().GetWidth())
            return true;
        return false;
    }

    //public Rectangle getMushroomRectangle(){return new Rectangle((int)x- Map.offset,(int)y,width,height);
    public Rectangle getMushroomRectangle(){return new Rectangle((int)x-5- Map.offset,(int)y-5,width,height);
    }
}
