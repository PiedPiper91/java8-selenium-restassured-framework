import com.fasterxml.jackson.core.JsonProcessingException;
import exceptions.JsonParsingException;
import models.TestData;
import models.User;
import utilities.DateUtil;
import utilities.JsonUtil;
import utilities.LoggerUtil;

import java.io.IOException;

public class TestDataRunner {
    public static void main(String[] args) throws IOException, JsonParsingException {
        TestData testdatafromjson = JsonUtil.readTestData();
        testdatafromjson.getUsers().forEach(user -> {
            LoggerUtil.info("Test execution started at"+DateUtil.getCurrentDateTime());
            LoggerUtil.info(user.getUsername());
            LoggerUtil.info(user.getRole());
        });
    }
}
