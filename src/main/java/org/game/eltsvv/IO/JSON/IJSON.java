package org.game.eltsvv.IO.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface IJSON<T> {
    public List<T> getList(String jsonString) throws JsonProcessingException;
    public String getJSON (List<T> list) throws IOException;
}
