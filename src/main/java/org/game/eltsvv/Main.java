package org.game.eltsvv;

public class Main {
    public static void main(String[] args) {
        Player human =  HumanPlayer.getNewPlayer();
        //Player PC1 = new PCPlayer("PC1");
        Player PC2 = new PCPlayer("PC2");

        GameController gc = new GameController();
        gc.Start(human, PC2);

        // Сделать меню выбора
        // 1 - Игра Компьютер - Компьютер
        // 2 - Игра Игрок - Компьютер
        // Если выбрано 2, то создать Игрока
        // т.е. запросить у пользователя Name и создать HumanPlayer

        // добавить проверку ввода данных (цифры при выборе фигур, не пустая строка при вводе имени

    }
}



