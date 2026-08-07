package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.JsonParsingException;
import models.TestData;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil {

    public static TestData readTestData() throws JsonParsingException {
        InputStream inputStream = JsonUtil.class.getClassLoader().getResourceAsStream("testdata.json");
        final ObjectMapper MAPPER = new ObjectMapper();
        TestData testdatafromjson = null;
        try {
            testdatafromjson = MAPPER.readValue(inputStream, TestData.class);
        } catch (IOException e) {
            throw new JsonParsingException("Error in parsing JSON");
        }
        return testdatafromjson;
    }

}
