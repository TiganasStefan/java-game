package PAOO_GAME.Graphics;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Assets {

    public static BufferedImage box;
    public static BufferedImage boxLU;
    public static BufferedImage boxLD;
    public static BufferedImage boxRU;
    public static BufferedImage boxRD;
    public static BufferedImage pD;
    public static BufferedImage pR;
    public static BufferedImage pL;
    public static BufferedImage pU;
    public static BufferedImage cLU;
    public static BufferedImage cLD;
    public static BufferedImage cRU;
    public static BufferedImage cRD;
    public static BufferedImage fL;
    public static BufferedImage fR;
    public static BufferedImage fM;

    public static BufferedImage[] heroIdle;
    public static BufferedImage[] heroRun;
    public static BufferedImage[] heroRunBack;

    public static BufferedImage heroJumpBack;
    public static BufferedImage heroJump;
    public static BufferedImage heroFall;
    public static BufferedImage heroFallBack;

    public static BufferedImage start;
    public static BufferedImage gameOver;
    public static BufferedImage win;
    public static BufferedImage finish;
    public static BufferedImage life;
    public static BufferedImage background;

    public static BufferedImage[] strawberry;
    public static BufferedImage[] strawberry2;
    public static BufferedImage[] mushroom;
    public static BufferedImage[] mushroomBack;

    public static void Init()
    {
        SpriteSheet sheet=new SpriteSheet(ImageLoader.LoadImage("/tiles/Sprites/14-TileSets/Terrain (32x32).png"));
        SpriteSheet sheet2=new SpriteSheet(ImageLoader.LoadImage("/Ninja Frog/Idle (32x32).png"));
        SpriteSheet sheet3=new SpriteSheet(ImageLoader.LoadImage("/Ninja Frog/Run (32x32).png"));
        SpriteSheet sheet4=new SpriteSheet(ImageLoader.LoadImage("/Ninja Frog/RunBack (32x32).png"));
        SpriteSheet sheet5=new SpriteSheet(ImageLoader.LoadImage("/Strawberry/Strawberry2.png"));
        SpriteSheet sheet6 = new SpriteSheet(ImageLoader.LoadImage("/Strawberry/Strawberry.png"));
        SpriteSheet sheet7 = new SpriteSheet(ImageLoader.LoadImage("/Mushroom/Run (32x32).png"));
        SpriteSheet sheet8= new SpriteSheet(ImageLoader.LoadImage("/Mushroom/RunBack (32x32).png"));

        heroJump=ImageLoader.LoadImage("/Ninja Frog/Jump (32x32).png");
        heroJumpBack=ImageLoader.LoadImage("/Ninja Frog/JumpBack (32x32).png");
        heroFall=ImageLoader.LoadImage("/Ninja Frog/Fall (32x32).png");
        heroFallBack=ImageLoader.LoadImage("/Ninja Frog/FallBack (32x32).png");

        box = sheet.crop(5, 5);
        boxLU = sheet.crop(16, 4);
        boxLD = sheet.crop(16, 5);
        boxRU = sheet.crop(17, 4);
        boxRD = sheet.crop(17, 5);

        pD = sheet.crop(2, 3);
        pL = sheet.crop(1, 2);
        pR = sheet.crop(3, 2);
        pU = sheet.crop(2, 1);

        cLU = sheet.crop(1, 1);
        cLD = sheet.crop(1, 3);
        cRU = sheet.crop(3, 1);
        cRD = sheet.crop(3, 3);

        fL=sheet.crop(1,5);
        fR=sheet.crop(3,5);
        fM=sheet.crop(2,5);

        heroIdle=new BufferedImage[11];
        for (int i=0;i<11;i++) {
            heroIdle[i] = sheet2.crop(i, 0);
        }

        heroRun=new BufferedImage[12];
        for (int i=0;i<12;i++)
            heroRun[i]=sheet3.crop(i,0);

        heroRunBack=new BufferedImage[12];
        for (int i=0;i<12;i++)
            heroRunBack[i]=sheet4.crop(i,0);

        strawberry = new BufferedImage[17];
        strawberry2=new BufferedImage[6];
        mushroom = new BufferedImage[9];
        mushroomBack=new BufferedImage[9];

        for(int i=0;i<17;i++)
            strawberry[i] = sheet6.crop(i,0);

        for (int i=0;i<strawberry2.length;i++)
            strawberry2[i]=sheet5.crop(i,0);


        for(int i=0;i<mushroom.length;i++)
            mushroom[i] = sheet7.crop(i,0);

        for (int i=0;i<mushroomBack.length;i++)
            mushroomBack[i]=sheet8.crop(i,0);

        background=ImageLoader.LoadImage("/Yellow.jpeg");
        start= ImageLoader.LoadImage("/obj/start.png");
        finish=ImageLoader.LoadImage("/obj/finish.png");
        life=ImageLoader.LoadImage("/Ninja Frog/Fall (32x32).png");
        gameOver=ImageLoader.LoadImage("/endgame/GameOver.png");
        win=ImageLoader.LoadImage("/endgame/win.jpeg");












    }


}
