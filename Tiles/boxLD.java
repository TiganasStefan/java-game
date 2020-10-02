package PAOO_GAME.Tiles;

import PAOO_GAME.Graphics.Assets;

/*! \class public class SoilTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant.
 */
public class boxLD extends Tile
{
    /*! \fn public SoilTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public boxLD(int id)
    {
        super(Assets.boxLD, id);
    }

}
