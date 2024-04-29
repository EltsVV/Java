package org.game.eltsvv;

import org.game.eltsvv.IO.Console.MessageConsole;
import org.game.eltsvv.IO.Console.MessageService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        preMenu();
        int menuChoice;
        GameController gc = new GameController();
        do {
            gameMenu();
            menuChoice= getNumMenu();
            if (menuChoice == 1) {
                Player PC1 = new PCPlayer("PC1");
                Player PC2 = new PCPlayer("PC2");
                gc.start(PC1, PC2);
            } else if (menuChoice == 2) {
                Player human = HumanPlayer.getNewPlayer();
                Player PC = new PCPlayer("PC");
                gc.start(human, PC);
            } else if (menuChoice == 3) {
                messageService.sendToConsole("Введите кол-во побед для победы");
                int newScore = new Scanner(System.in).nextInt();
                gc.setScoreWin(newScore);
                messageService.sendToConsole("Кол-во побед для победы: " + gc.getScoreWin());
            }
            else if (menuChoice == 0) break;
        } while (menuChoice != 0);
    }

    private static int getNumMenu() {
        Scanner in = new Scanner(System.in);
        int numMenu = -1;
        do {
            numMenu = in.nextInt();
            if (numMenu < 0 || numMenu > 3)
                messageService.sendToConsole("Неверно выбрана пункт меню");
            else break;
        } while (true);
        return numMenu;
    }
    private static MessageService messageService = new MessageService(new MessageConsole());


    private static void preMenu(){
        System.out.print("\033[H\033[2J");
        messageService.sendToConsole("Добро пожаловат в игру Камень Ножницы Бумага");
        messageService.sendToConsole("Игра созданна при поддержке Princess Java");
    }

    private static void gameMenu(){
        messageService.sendToConsole("");
        messageService.sendToConsole("Выберите вариант игры:");
        messageService.sendToConsole("1 - Игра: Компьютер - Компьютер");
        messageService.sendToConsole("2 - Игра: Игрок - Компьютер");
        messageService.sendToConsole("3 - Игра: Настройка счёта");
        messageService.sendToConsole("0 - Выход");

    }
}



