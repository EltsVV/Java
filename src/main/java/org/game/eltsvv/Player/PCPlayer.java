package org.game.eltsvv.Player;

public class PCPlayer extends Player {

    public PCPlayer(String Name) {
        super(Name);
    }

    @Override
    public void choiceFigure() {
        setCurrentFigure(Figure.getFigure());
    }
}
