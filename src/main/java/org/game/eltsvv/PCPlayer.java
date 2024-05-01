package org.game.eltsvv;

public class PCPlayer extends Player {

    PCPlayer(String Name) {
        super(Name);
    }

    PCPlayer() {
        super("Name");
    }
    @Override
    public void choiceFigure() {
        setCurrentFigure(Figure.getFigure());
    }
}
