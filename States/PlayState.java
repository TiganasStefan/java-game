package PAOO_GAME.States;

import PAOO_GAME.Graphics.Assets;
import PAOO_GAME.Items.Hero;
import PAOO_GAME.RefLinks;
import PAOO_GAME.Maps.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayState extends State {

    private Hero hero;
    private Map map;

    public PlayState(RefLinks refLink)
    {
        super(refLink);
        map=new Map(refLink);
        refLink.SetMap(map);
        hero=new Hero(refLink,40,410);
        refLink.GetGame().score=0;
    }

    @Override
    public void Update() {
        map.Update();
        hero.Update();

        if (refLink.GetKeyManager().esc==true)
            State.SetState(refLink.GetGame().MenuState);
    }

    @Override
    public void Draw(Graphics g) {
        map.Draw(g);
        hero.Draw(g);

    }

    @Override
    public void resetState() {
        Map.offset = 0;
        hero=new Hero(refLink,40,410);
    }
}
