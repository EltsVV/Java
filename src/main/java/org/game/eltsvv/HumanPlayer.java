package org.game.eltsvv;

import org.game.eltsvv.MessageConsole.MessageConsole;
import org.game.eltsvv.MessageConsole.MessageService;

import java.util.Scanner;

public class HumanPlayer extends Player {

    HumanPlayer(String name) {
        super(name);
    }

    public static HumanPlayer getNewPlayer() {
        MessageService messageService = new MessageService(new MessageConsole());
        messageService.sendToConsole("Введите ваше имя");
        Scanner in = new Scanner(System.in);
        return new HumanPlayer(in.next());
    }

    @Override
    public void choiceFigure() {
        MessageService messageService = new MessageService(new MessageConsole());
        messageService.sendToConsole("Выберите номер фигуры:");
        Figure.printFigures();

        Figure tmpFigure = null;

        Scanner in = new Scanner(System.in);
        do {
            int numFigure = -1;
            numFigure = in.nextInt();
            tmpFigure = Figure.getFigure(numFigure);

            if (tmpFigure == null)
                messageService.sendToConsole("Неверно выбрана фигура");
        } while (tmpFigure == null);

        setCurrentFigure(tmpFigure);
    }

}
