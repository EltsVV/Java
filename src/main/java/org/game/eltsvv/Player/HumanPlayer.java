package org.game.eltsvv.Player;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.game.eltsvv.Figure;
import org.game.eltsvv.IO.Console.MessageConsole;
import org.game.eltsvv.IO.Console.MessageService;

import java.util.Scanner;

//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@JsonPropertyOrder({"name", "score"})
public class HumanPlayer extends Player {

    HumanPlayer(String name) {
        super(name);
    }
    private HumanPlayer() {
        super("");
    }

    public static HumanPlayer createNewPlayer() {
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
