package PAOO_GAME.Items;

import PAOO_GAME.Maps.Map;
import PAOO_GAME.RefLinks;
import PAOO_GAME.States.State;
import PAOO_GAME.Tiles.Tile;

public abstract class Character extends Item {

    public static final int DEFAULT_LIFE = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32;
    public static final int DEFAULT_CREATURE_HEIGHT =32;


    protected int life;
    protected float speed;
    protected float xMove;
    protected float yMove;

    protected boolean jump=false;

    public Character(RefLinks refLink, float x, float y, int width, int height) {

        super(refLink, x, y, width, height);
        life = DEFAULT_LIFE;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void Move(boolean movex) {


            if (y>refLink.GetGame().GetHeight())
                State.SetState(refLink.GetGame().MenuState);

            if (movex==true)
                MoveX();
            MoveY();


    }

    public float canMoveX(float d){

        for (float h=bounds.y ; h<=(bounds.y+bounds.height); h+=bounds.height/2.) {
            if (d>0 && refLink.GetMap().getSolid(bounds.x + bounds.width + d, h) ||
                    d<0 && refLink.GetMap().getSolid(bounds.x + d, h))
                return 0;
        }

        return d;
    }

    public float canMoveY(float d){

        for (float w=bounds.x ; w<=(bounds.x+bounds.width); w+=bounds.width/2.) {
            if (d > 0 && refLink.GetMap().getSolid(w, bounds.y + bounds.height + d))
            {
                jump = false;
                return 0;
            }
            if (d < 0 && refLink.GetMap().getSolid(w, bounds.y + d) )
            {
                return 0;
            }
        }

        return d;
    }




    public void MoveX() {
        x += xMove;
        bounds.x += xMove;
    }

    public void MoveY() {
        y += yMove;
        bounds.y += yMove;
    }

    public int GetLife() {
        return life;
    }

    public float GetSpeed() {
        return speed;
    }

    public void SetLife(int life) {
        this.life = life;
    }

    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    public float GetXMove() {
        return xMove;
    }

    public float GetYMove() {
        return yMove;
    }

    public void SetXMove(float xMove)
    {
        this.xMove=xMove;
    }

    public void SetYMOve(float yMove)
    {
        this.yMove=yMove;
    }

}
