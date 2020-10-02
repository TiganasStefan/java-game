package PAOO_GAME.Maps;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.Items.Mushroom;
import PAOO_GAME.Items.Strawberry;
import PAOO_GAME.RefLinks;
import PAOO_GAME.Tiles.Tile;

import java.awt.*;

public class Map {

    private RefLinks refLink;
    private int width;
    private int height;
    private  static int [][] tiles;

    public static Strawberry[] Strawberry;
    public static Mushroom[] Mushroom;
    private Color Color;

    public static int offset=0;

    public void Coins(){
        Strawberry = new Strawberry[14];
        Strawberry[0]=new Strawberry(refLink,30,60);
        Strawberry[1]=new Strawberry(refLink,100,60);
        Strawberry[2]=new Strawberry(refLink,225,60);
        Strawberry[3]=new Strawberry(refLink,355,60);
        Strawberry[4]=new Strawberry(refLink,480,70);
        Strawberry[5]=new Strawberry(refLink,440,300);
        Strawberry[6]=new Strawberry(refLink,440,320);
        Strawberry[7]=new Strawberry(refLink,440,340);
        Strawberry[8]=new Strawberry(refLink,440,360);
        Strawberry[9]=new Strawberry(refLink,440,380);
        Strawberry[10]=new Strawberry(refLink,1540,170);
        Strawberry[11]=new Strawberry(refLink,1400,190);
        Strawberry[12]=new Strawberry(refLink,1400,320);
        Strawberry[13]=new Strawberry(refLink,1540,300);
    }

    public void Enemy(){
        Mushroom = new Mushroom[10];

        Mushroom[0] = new Mushroom(refLink,450,417,340);
        Mushroom[6] = new Mushroom(refLink,525,417,340);
        Mushroom[1] = new Mushroom(refLink,600,417,340);
        Mushroom[7] = new Mushroom(refLink,675,417,340);
        Mushroom[2] = new Mushroom(refLink,750,417,340);
        Mushroom[8] = new Mushroom(refLink,825,417,340);
        Mushroom[3] = new Mushroom(refLink,900,417,340);
        Mushroom[4] = new Mushroom(refLink,1050,417,340);
        Mushroom[5] = new Mushroom(refLink,1200,417,340);
        Mushroom[9] = new Mushroom(refLink,25,128,80);
    }


    public Map(RefLinks refLink)
    {
        this.refLink=refLink;
        LoadWorld();
        Coins();
        Enemy();
    }

    public void Update()
    {
        for (int i = 0; i < Strawberry.length; i++)
            Strawberry[i].Update();
        for (int i = 0; i < Mushroom.length; i++)
            Mushroom[i].Update();

    }

    public void Draw(Graphics g)
    {
        g.drawImage(Assets.background,0,0,null);
        g.setFont(new Font("Times New Roman",Font.PLAIN,25));
        Color=new Color(212, 4, 4, 233);
        g.setColor(Color);
        g.drawString("Score: " + refLink.GetGame().score,250,55);

        if (offset<0)
            offset=0;

        for (int y=0;y<refLink.GetGame().GetHeight()/ Tile.TILE_HEIGHT;y++)
        {
            for (int x=0+(offset/Tile.TILE_WIDTH);x<(refLink.GetGame().GetWidth()+offset)/Tile.TILE_WIDTH+1;x++)
            {

                if (GetTile(x,y)!=null)
                    GetTile(x,y).Draw(g,(int)x*Tile.TILE_HEIGHT-offset,(int)y*Tile.TILE_WIDTH);

            }
        }
        g.drawImage(Assets.start, 40-offset , 393, 44, 55, null);


        for (int i = 0; i < Strawberry.length; i++)
            Strawberry[i].Draw(g);
        for (int i = 0; i < Mushroom.length; i++)
            Mushroom[i].Draw(g);

        g.drawImage(Assets.finish, 1500-offset,108,60,20,null);


    }

    public static Tile GetTile(int x,int y)
    {
        if(tiles[x][y]==0)
            return null;
        Tile t = Tile.tiles[tiles[x][y]];
        return t;

    }

    private void LoadWorld()
    {
        width = 50;
        height =15;
        tiles = new int[width][height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = MiddleEastMap(y, x);
            }
        }
    }

    private int MiddleEastMap(int x ,int y)
    {
        final int map[][] = {
                {21,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,23},
                {40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,97,98,98,99,42},
                {40,97,98,99,0,0,0,101,0,0,0,101,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,101,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,101,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,93,94,0,0,0,0,101,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,101,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,0,0,112,113,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,93,94,93,94,0,0,0,0,0,0,0,101,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,101,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,0,0,112,113,112,113,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {40,0,0,0,0,0,0,0,93,94,93,94,93,94,0,0,0,0,0,0,0,0,0,0,101,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,101,0,0,0,42},
                {40,0,0,0,0,0,0,0,112,113,112,113,112,113,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,42},
                {59,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,61}};
        return map[x][y];
    }

    public int getMapWidth()
    {
        return width*Tile.TILE_WIDTH;
    }

    public boolean getSolid(float w, float h) {
        try {
            return tiles[(int)((w + offset) / Tile.TILE_HEIGHT)][(int)(h / Tile.TILE_WIDTH)] != 0;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }



}
