package org.game.eltsvv.Player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.game.eltsvv.Figure;
import org.game.eltsvv.IO.Console.MessageConsole;
import org.game.eltsvv.IO.Console.MessageService;
import org.game.eltsvv.IO.File.FileIO;
import org.game.eltsvv.IO.File.FileIOService;
import org.game.eltsvv.IO.JSON.JSON;
import org.game.eltsvv.IO.JSON.JSONService;

import java.util.LinkedList;
import java.util.List;

//@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = HumanPlayer.class, name = "HumanPlayer")
//})
public abstract class Player {
    @JsonProperty("name")
    private String name;
    @JsonProperty("total_score")
    private int score;
    @JsonIgnore
    private Figure currentFigure;
    @JsonIgnore
    public static List<HumanPlayer> list = new LinkedList<>();

    @JsonIgnore
    static FileIOService writeFileService = new FileIOService(new FileIO("Player.dat"));

    Player(String _name) {
        name = _name;
    }

    private static void getHighScore() {
        String jsonString = writeFileService.readFile();
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = mapper.readValue(jsonString, new TypeReference<List<HumanPlayer>>(){});
        } catch (JsonProcessingException e) {
            list = new LinkedList<>();
        }
    }

    public static void printHighScore() {
        int length = list.toArray().length;
        if (length == 0)
            getHighScore();
        list.sort(new ComparatorByScorePlayerDESC());
        MessageService messageService = new MessageService(new MessageConsole());
        if (length != 0) messageService.sendToConsole("Таблица чемпионов");
        else messageService.sendToConsole("Таблица чемпионов - пуста");
        for (var item : list){
            messageService.sendToConsole( ((HumanPlayer)item).getName() + " - " +  ((HumanPlayer)item).getScore());
        }
    }

    public static void saveWinnerHighScore() {
        if (list.toArray().length != 0) {
            JSONService<HumanPlayer> jsonService = new JSONService<>(new JSON<>());
            try {
                writeFileService.writeToFile(jsonService.getJSON(list));
            } catch (Exception e) {
                MessageService messageService = new MessageService(new MessageConsole());
                messageService.sendToConsole("При сохранении результатов игры произошла ошибка");
            }
        }
    }

    public void addWinnerHighScore() {
        if (this instanceof HumanPlayer) {
            var currentPlayer = (Player) (list.stream()
                    .filter(x -> x.getName().equals(this.name))
                    .findFirst()
                    .orElse(null));

            if (currentPlayer != null) {//(Player)currentPlayer.score++;
                currentPlayer.score++;
            } else {
                this.score = 1;
                list.add((HumanPlayer) this);
            }
        }
    }

    protected void setCurrentFigure(Figure _currentFigure){
        currentFigure = _currentFigure;
    }

    public Figure getCurrentFigure(){
        return currentFigure;
    }

    public String getName(){
        return name;
    }

    public void setScore(int _score){
        score = _score;
    }

    public int getScore(){
        return score;
    }

    public void playerReset() {
        score = 0;
        currentFigure = null;
    }

    public abstract void choiceFigure();

}


