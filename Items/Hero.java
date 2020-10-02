package PAOO_GAME.Items;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.Maps.Map;
import PAOO_GAME.RefLinks;
import PAOO_GAME.States.State;
import PAOO_GAME.States.MenuState;
import PAOO_GAME.States.PlayState;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends Character {

    private BufferedImage[] image;
    private int contor = 0;
    private boolean[] StrawberryIntersection;
    private boolean[] MushroomIntersection;
    private Color Color;

    public float jumpStrength;

    public Hero(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        image = new BufferedImage[11];
        image = Assets.heroIdle;


        bounds.x = (int) x;
        bounds.y = (int) y;
        bounds.width = Character.DEFAULT_CREATURE_WIDTH;
        bounds.height = Character.DEFAULT_CREATURE_HEIGHT;

        StrawberryIntersection = new boolean[Map.Strawberry.length];
        MushroomIntersection = new boolean[Map.Mushroom.length];
    }

        public void collisionStrawberry(){
            for(int i=0;i<Map.Strawberry.length;i++)
            {
                if(new Rectangle((int)x,(int)y,width,height).intersects(Map.Strawberry[i].getStrawberryRectangle())==true) {
                    if (StrawberryIntersection[i] == false) {
                        Map.Strawberry[i].existent = false;
                        Map.Strawberry[i].collected = true;
                        refLink.GetGame().score++;
                        StrawberryIntersection[i] = true;
                    }
                }
            }
        }

        private void collisionMushroom(){
            for(int i=0;i<Map.Mushroom.length;i++)
            {
                if(new Rectangle((int)x,(int)y,width,height).intersects(Map.Mushroom[i].getMushroomRectangle())==true)
                {
                    if(MushroomIntersection[i]==false){
                        Life();
                        life-=1;
                        MushroomIntersection[i] = true;
                    }
                }
                else {
                    MushroomIntersection[i]=false;
                }
            }
        }


        private void Life()
        {
            if (life<=0) {
                State.SetState(refLink.GetGame().GameOverState);
                refLink.GetGame().score = 0;
                for(int i=0;i<Map.Strawberry.length;i++)
                Map.Strawberry[i].existent = true;
            }

        }

        private void finish()
        {
            if (new Rectangle((int)x,(int)y,width,height).intersects(new Rectangle(1520-Map.offset,40,64,64)) && refLink.GetGame().score==14)
            {State.SetState(refLink.GetGame().WinState);
                refLink.GetGame().score = 0;
                for(int i=0;i<Map.Strawberry.length;i++)
                    Map.Strawberry[i].existent = true;
                }
        }




    @Override
    public void Update() {

        GetInput();
        if (x+xMove<refLink.GetGame().GetWidth()/2)
            Move(true);
        else
        {
            if (Map.offset+ refLink.GetGame().GetWidth() +xMove <refLink.GetMap().getMapWidth())
            {
                Map.offset +=xMove;
                Move(false);
            }
            else
            {
                Move(true);
            }
        }

        collisionStrawberry();
        collisionMushroom();
        finish();

        if(y>refLink.GetHeight())
            State.SetState(refLink.GetGame().GameOverState);


        System.out.print(x + Map.offset + "     ");
        System.out.println(y);


        System.out.println("Lifes:    " + life);

    }

    private void GetInput(){
        xMove = 0;
        yMove = 0;

        contor++;
        if (contor > 30)
            contor = 0;

        if (refLink.GetKeyManager().left == true) {
            image = Assets.heroRunBack;
        } else if (refLink.GetKeyManager().right == true) {
            image = Assets.heroRun;

        } else {
            image = Assets.heroIdle;
        }


        if (refLink.GetKeyManager().up) {
            yMove = canMoveY(-speed);

        }
        if (refLink.GetKeyManager().down) {
            yMove = canMoveY(speed);

        }
        if (refLink.GetKeyManager().left) {
            xMove = canMoveX(-speed);

        }
        if (refLink.GetKeyManager().right) {
            xMove = canMoveX(speed);
        }

        if (refLink.GetKeyManager().up == true && jump==false) {

            jumpStrength=-15;
            jumpStrength=canMoveY(++jumpStrength);
            yMove=jumpStrength;
            jump=true;

        }
        jumpStrength=canMoveY(++jumpStrength);
        yMove=jumpStrength;



    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color);
        Color=new Color(3, 146, 28, 255);
        g.drawString("Lives:", 40, 55);
        for (int i=0;i<life;i++)
        {
            g.drawImage(Assets.life,100+i*33,30,33,30,null);

        }
        if (jump==true) {
            if (jumpStrength < 0)
                if (refLink.GetKeyManager().left == true)
                    g.drawImage(Assets.heroJumpBack,(int)x,(int)y,width,height,null);
                else
                    g.drawImage(Assets.heroJump, (int) x, (int) y, width, height, null);
            else
            if (refLink.GetKeyManager().left == true)
                g.drawImage(Assets.heroFallBack, (int) x, (int) y, width, height, null);
            else
                g.drawImage(Assets.heroFall, (int) x, (int) y, width, height, null);


        }
        else
            g.drawImage(image[contor / 3], (int) x, (int) y, width, height, null);
    }

}


