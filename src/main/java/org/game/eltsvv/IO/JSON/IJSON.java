package org.game.eltsvv.IO.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.game.eltsvv.Player.HumanPlayer;

import java.io.IOException;
import java.util.List;

public interface IJSON<T> {
    List<HumanPlayer> getList(String jsonString) throws JsonProcessingException;

    String getJSON (List<T> list) throws IOException;
}
