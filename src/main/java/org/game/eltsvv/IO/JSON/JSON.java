package org.game.eltsvv.IO.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class JSON<T> implements IJSON<T> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public List<T> getList(String jsonString) throws JsonProcessingException {
        return mapper.readValue(jsonString,  List.class);

    }

    @Override
    public String getJSON(List<T> list) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, list);
        return writer.toString();
    }
}
