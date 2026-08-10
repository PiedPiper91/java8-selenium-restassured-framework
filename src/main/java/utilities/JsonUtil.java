package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.JsonParsingException;
import models.TestData;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static TestData readTestData() throws JsonParsingException {
        InputStream inputStream = JsonUtil.class.getClassLoader().getResourceAsStream("testdata.json");
        if (inputStream == null) {
            throw new JsonParsingException(
                    "testdata.json not found in resources."
            );
        }
        TestData testdatafromjson = null;
        try {
            testdatafromjson = MAPPER.readValue(inputStream, TestData.class);
        } catch (IOException e) {
            throw new JsonParsingException("Error in parsing testdata.json");
        }
        return testdatafromjson;
    }

}
