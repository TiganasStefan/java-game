package PAOO_GAME.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private static final int NO_TILES = 254;
    public static Tile[] tiles = new Tile[NO_TILES];

    public static Tile box           = new box(101);
    public static Tile boxLU         = new boxLU(93);
    public static Tile boxLD         = new boxLD(112);
    public static Tile boxRU         = new boxRU(94);
    public static Tile boxRD         = new boxRD(113);
    public static Tile pD            = new pD(60);
    public static Tile pU            = new pU(22);
    public static Tile pR            = new pR(42);
    public static Tile pL            = new pL(40);
    public static Tile cLU           = new cLU(21);
    public static Tile cLD           = new cLD(59);
    public static Tile cRU           = new cRU(23);
    public static Tile cRD           = new cRD(61);
    public static Tile fL            = new fL(97);
    public static Tile fR            = new fR(99);
    public static Tile fM            = new fM(98);

    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd) {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    public void Update() {


    }

    public void Draw(Graphics g, int x, int y) {
        //GetTile();
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);

    }

    public boolean IsSolid() {
        return false;

    }

    public int GetId() {
        return id;
    }


}
