package org.game.eltsvv;

import org.game.eltsvv.MessageConsole.MessageConsole;
import org.game.eltsvv.MessageConsole.MessageService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        gameMenu();
        int menuChoice = getNumMenu();

        GameController gc = new GameController();
        if (menuChoice == 1) {
            Player PC1 = new PCPlayer("PC1");
            Player PC2 = new PCPlayer("PC2");
            gc.Start(human, PC2);
        }
        else if (menuChoice == 2) {
            Player human =  HumanPlayer.getNewPlayer();
            Player PC2 = new PCPlayer("PC2");
            gc.Start(human, PC2);
        }
        // Сделать меню выбора
        // 1 - Игра Компьютер - Компьютер
        // 2 - Игра Игрок - Компьютер
        // Если выбрано 2, то создать Игрока
        // т.е. запросить у пользователя Name и создать HumanPlayer

        // добавить проверку ввода данных (цифры при выборе фигур, не пустая строка при вводе имени

    }

    private static int getNumMenu() {
        Scanner in = new Scanner(System.in);
        int numMenu ;
        do {
            numMenu = in.nextInt();
            if (numMenu < 0 || numMenu > 2)
                messageService.sendToConsole("Неверно выбрана пункт меню");
            else numMenu = 0;
        } while (true);
    }
    private static MessageService messageService = new MessageService(new MessageConsole());
    private static void gameMenu(){

        messageService.sendToConsole("Добро пожаловат в игру Камень Ножницы Бумага");
        messageService.sendToConsole("Игра созданна при поддержке Princess Java");
        messageService.sendToConsole("");
        messageService.sendToConsole("Выберите вариант игры:");
        messageService.sendToConsole("1 - Игра: Компьютер - Компьютер");
        messageService.sendToConsole("2 - Игра: Игрок - Компьютер");
    }
}



