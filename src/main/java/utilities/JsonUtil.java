package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.TestData;

public class JsonUtil {

    public static TestData readTestData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TestData testdatafromjson = mapper.readValue("src/main/resources/testdata.json", TestData.class);
        return testdatafromjson;
    }

}
