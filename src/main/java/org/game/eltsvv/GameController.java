package org.game.eltsvv;

import org.game.eltsvv.MessageConsole.MessageConsole;
import org.game.eltsvv.MessageConsole.MessageService;

public class GameController {
    private MessageService messageService = new MessageService(new MessageConsole());
    private int scoreWin = 3;

    public void setScoreWin(int _scoreWin){
        if(scoreWin > 0)
            scoreWin = _scoreWin;
    }

    private void ShowCurrentFigure(Player p1) {
        messageService.sendToConsole(p1.getName() + ": выбросил " + p1.getCurrentFigure());
    }

    private void SelectFigure(Player player1, Player player2){
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

    public void Start(Player player1, Player player2) {
        int round = 0;

        while (true){
            round++;
            SelectFigure(player1, player2);
            Player roundWinner = beatsRound(player1, player2);
            ShowCurrentFigure(player1);
            ShowCurrentFigure(player2);
            ShowWinner(roundWinner);
            ShowScore(round, player1, player2);
            if (roundWinner != null && roundWinner.getScore() == scoreWin)
                break;
        }
    }

    private void ShowScore(int round, Player P1, Player P2) {
        messageService.sendToConsole("Раунд:"+ round+ " " + P1.getName()+" = "+ P1.getScore() +" VS "+ P2.getName()+" = "+ P2.getScore());
    }

    private void ShowWinner(Player roundWinner) {
        if  (roundWinner == null)
            messageService.sendToConsole("Никто не выиграл");
        else{
            messageService.sendToConsole(roundWinner.getName() + " выиграл раунд ");
            roundWinner.setScore(roundWinner.getScore() + 1);
        }
    }
}
