package org.game.eltsvv.Player;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.game.eltsvv.IO.Console.MessageConsole;
import org.game.eltsvv.IO.Console.MessageService;
import org.game.eltsvv.IO.File.FileIO;
import org.game.eltsvv.IO.File.FileIOService;
import org.game.eltsvv.IO.JSON.JSON;
import org.game.eltsvv.IO.JSON.JSONService;

import java.util.LinkedList;
import java.util.List;

public class HighScoreTable {
    private static List<HumanPlayer> list = new LinkedList<>();

    public HighScoreTable () {
        LoadHighScoreList(writeFileService.readFile());
    }

    FileIOService writeFileService = new FileIOService(new FileIO( "Player.dat"));
    JSONService<HumanPlayer> jsonService = new JSONService<>(new JSON<>());

    private void LoadHighScoreList(String jsonString ) {
        try {
            list = jsonService.getList(jsonString);
        } catch (JsonProcessingException e) {
            list = new LinkedList<>();
        }
    }

    public void printHighScore() {
        list.sort(new ComparatorByScorePlayerDESC());

        MessageService messageService = new MessageService(new MessageConsole());

        if (list.toArray().length != 0) messageService.sendToConsole("Таблица чемпионов");
        else messageService.sendToConsole("Таблица чемпионов - пуста");
        for (var item : list){
            messageService.sendToConsole( ((HumanPlayer)item).getName() + " - " +  ((HumanPlayer)item).getScore());
        }
    }

    public void saveWinnerHighScore() {
        if (list.toArray().length != 0) {
            try {
                writeFileService.writeToFile(jsonService.getJSON(list));
            } catch (Exception e) {
                MessageService messageService = new MessageService(new MessageConsole());
                messageService.sendToConsole("При сохранении результатов игры произошла ошибка");
            }
        }
    }

    public void addWinnerHighScore(Player player) {
        if (player instanceof HumanPlayer) {
            var currentPlayer = (Player) (list.stream()
                    .filter(x -> x.getName().equals(player.getName()))
                    .findFirst()
                    .orElse(null));

            if (currentPlayer != null) {//(Player)currentPlayer.score++;
                currentPlayer.setScore(currentPlayer.getScore() + 1);
            } else {
                player.setScore(1);
                list.add((HumanPlayer) player);
            }
        }
    }
}
