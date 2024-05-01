package org.game.eltsvv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.game.eltsvv.IO.File.FileIO;
import org.game.eltsvv.IO.File.FileIOService;
import org.game.eltsvv.IO.JSON.JSON;
import org.game.eltsvv.IO.JSON.JSONService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = HumanPlayer.class, name = "HumanPlayer")
//})
public abstract class Player  {
    @JsonProperty("name")
    private String name;
    @JsonProperty("total_score")
    private int score;
    @JsonIgnore
    private Figure currentFigure;
    @JsonIgnore
    @JsonDeserialize(contentAs=Player.class)
    public static List<HumanPlayer> list = new LinkedList<>();

    private Player() {}
    Player(String _name) {
        name = _name;
    }

    public static List getHighScore() {
        String jsonString = writeFileService.readFile();
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = mapper.readValue(jsonString, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            list = new LinkedList<>();
        }
    }

    protected void setCurrentFigure(Figure _currentFigure){
        currentFigure = _currentFigure;
    }

    protected Figure getCurrentFigure(){
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
    @JsonIgnore
    static FileIOService writeFileService = new FileIOService(new FileIO());
    JSONService<HumanPlayer> jsonService = new JSONService<>(new JSON<>());
    public void save() throws JsonProcessingException {
        loadDate();


        var currentPlayer = (Player)(list.stream()
                                            .filter(x->x.getName().equals(this.name))
                                            .findFirst()
                                            .orElse(null));

        if (currentPlayer != null) {//(Player)currentPlayer.score++;
            currentPlayer.score++;
        }
        else
            list.add((HumanPlayer) this);

        try {
            writeFileService.writeToFile(jsonService.getJSON(list));
        } catch (IOException e) {
            ;
        }
    }

    private void loadDate(){
        String jsonString = writeFileService.readFile();
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = mapper.readValue(jsonString, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            list = new LinkedList<>();
        }


//        try {
//            list =  jsonService.getList(jsonString);
//        } catch (JsonProcessingException e) {
//            list = new LinkedList<HumanPlayer>();
//        }
    }
}


