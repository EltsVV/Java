package org.game.eltsvv.Player;

import org.game.eltsvv.Figure;

public class PCPlayer extends Player {

    public PCPlayer(String Name) {
        super(Name);
    }

    @Override
    public void choiceFigure() {
        setCurrentFigure(Figure.getFigure());
    }
}
