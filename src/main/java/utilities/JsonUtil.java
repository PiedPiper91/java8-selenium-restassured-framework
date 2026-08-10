package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.JsonParsingException;
import models.TestData;

import java.io.IOException;
import java.io.InputStream;

import static constants.FrameworkConstants.TEST_DATA_FILE;

public class JsonUtil {

    private JsonUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static TestData readTestData() throws JsonParsingException {
        InputStream inputStream = JsonUtil.class.getClassLoader().getResourceAsStream(TEST_DATA_FILE);
        if (inputStream == null) {
            throw new JsonParsingException("testdata.json not found in resources.",null);
        }
        TestData testdatafromjson = null;
        try {
            testdatafromjson = MAPPER.readValue(inputStream, TestData.class);
        } catch (IOException e) {
            throw new JsonParsingException("Error in parsing testdata.json",e);
        }
        return testdatafromjson;
    }

}
