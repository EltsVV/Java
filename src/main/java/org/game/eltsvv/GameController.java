package org.game.eltsvv;

import org.game.eltsvv.IO.Console.MessageConsole;
import org.game.eltsvv.IO.Console.MessageService;
import org.game.eltsvv.Player.Player;

public class GameController {
    private final MessageService messageService = new MessageService(new MessageConsole());

    private int scoreWin = 3;

    public void setScoreWin(int _scoreWin){
        if(scoreWin > 0)
            scoreWin = _scoreWin;
    }

    public int getScoreWin() {
        return scoreWin;
    }

    private void showCurrentFigure(Player p1) {
        messageService.sendToConsole(p1.getName() + ": выбросил " + p1.getCurrentFigure());
    }

    private void selectFigure(Player player1, Player player2){
        player1.choiceFigure();
        player2.choiceFigure();
    }

    private Player beatsRound(Player player1, Player player2){

        if (player1.getCurrentFigure() == player2.getCurrentFigure())
            return null;
        if (player1.getCurrentFigure().beats(player2.getCurrentFigure()))
            return player1;
        else
            return player2;
    }

    public Player start(Player player1, Player player2) {
        int round = 0;
        while (true){
            round++;
            selectFigure(player1, player2);
            Player roundWinner = beatsRound(player1, player2);
            showCurrentFigure(player1);
            showCurrentFigure(player2);
            showRoundWinner(roundWinner);
            showScore(round, player1, player2);
            if (roundWinner != null && roundWinner.getScore() == scoreWin) {
                showWinner(roundWinner);
                return roundWinner;
            }
        }
    }

    private void showScore(int round, Player P1, Player P2) {
        messageService.sendToConsole("\u001B[32m");
        messageService.sendToConsole("Раунд:"+ round+ " " + P1.getName()+" = "+ P1.getScore() +" VS "+ P2.getName()+" = "+ P2.getScore());
        messageService.sendToConsole("\u001B[0m");
    }

    private void showRoundWinner(Player roundWinner) {
        if  (roundWinner == null)
            messageService.sendToConsole("Никто не выиграл");
        else{
            messageService.sendToConsole(roundWinner.getName() + " выиграл раунд ");
            roundWinner.setScore(roundWinner.getScore() + 1);
        }
    }

    private void showWinner(Player roundWinner) {
        messageService.sendToConsole("\u001B[31m" +roundWinner.getName() + " - ПОБЕДИЛ!!!!\u001B[0m");
    }

    /*public void printHighScore() {
        highScoreTable.printHighScore();
    }

    private void addWinnerHighScore(Player winner) {
        highScoreTable.addWinnerHighScore(winner);
    }

    public void saveBeforeExit() {
        highScoreTable.saveWinnerHighScore();
    }*/
}
