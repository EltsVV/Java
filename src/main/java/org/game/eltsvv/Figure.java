package org.game.eltsvv;

import java.util.Map;
import java.util.Random;
import java.util.Set;

enum  Figure {

    Камень, Ножницы, Бумага, Колодец;

    private static Map<Figure, Set<Figure>> beatsMap = Map.of(
            Камень, Set.of(Ножницы),
            Ножницы, Set.of(Бумага),
            Бумага, Set.of(Камень, Колодец),
            Колодец, Set.of(Камень, Ножницы)
    );

    private static final Random random = new Random();

    public static Figure getFigure() {
        Figure[] figures = Figure.values();
        int length = figures.length;
        return figures[random.nextInt(length)];
    }

    public static void printFigures(){
        for(Figure figure:Figure.values()){
            System.out.println(figure.ordinal() + " - " + figure);
        }
    }

    public static Figure getFigure(int numFigure) {
        Figure[] figures = Figure.values();
        if (numFigure >= 0 && numFigure < figures.length){
            return figures[numFigure];
        }
        else return null;
    }

    public boolean beats(Figure figure) {
        return beatsMap.get(this).contains(figure);
    }
}
