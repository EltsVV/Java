package org.game.eltsvv.IO.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface IJSON<T> {
    List<T> getList(String jsonString) throws JsonProcessingException;

    String getJSON (List<T> list) throws IOException;
}
