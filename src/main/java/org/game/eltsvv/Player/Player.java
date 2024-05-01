package org.game.eltsvv.Player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = HumanPlayer.class, name = "HumanPlayer")
//})
public abstract class Player {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("total_score")
    private int score;
    @JsonIgnore
    private Figure currentFigure;

    @JsonIgnore
    Player(String _name) {
        name = _name;
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


