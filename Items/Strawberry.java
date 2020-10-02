package PAOO_GAME.Items;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.Maps.Map;
import PAOO_GAME.RefLinks;

import java.awt.*;

public class Strawberry extends Character {


    public boolean existent = true;
    public boolean collected=false;
    private int contor = 0;
    private int animation_timer=0;

    public Strawberry(RefLinks refLink, float x, float y){
        super(refLink,x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void Update() {
        contor++;
        if(contor>60)
            contor = 0;
        if (collected==true)
        {
            animation_timer++;
            if (animation_timer>35)
            {
                collected=false;
                animation_timer=0;
            }
        }
    }

    @Override
    public void Draw(Graphics g) {

        if(existent==true)
            g.drawImage(Assets.strawberry[contor/4],(int) x - Map.offset, (int)y, width, height, null);
       if (collected==true)
           g.drawImage(Assets.strawberry2[animation_timer / 6], (int) x - Map.offset, (int) y, width, height, null);

    }

    public Rectangle getStrawberryRectangle(){
       return new Rectangle((int)x+5- Map.offset,(int)y+5,width-5,height-5);
    }

}
