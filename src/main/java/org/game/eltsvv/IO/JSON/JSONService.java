package org.game.eltsvv.IO.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public class JSONService<T> {
    IJSON<T> iJSON;

    public JSONService (IJSON<T> _iJSON){
        iJSON= _iJSON;
    }

    public List<T> getList(String jsonString) throws JsonProcessingException {
       return iJSON.getList(jsonString);
    }

    public String getJSON(List<T> list) throws IOException {
        return iJSON.getJSON(list);
    }
}
