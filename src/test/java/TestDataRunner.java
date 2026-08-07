import com.fasterxml.jackson.core.JsonProcessingException;
import models.TestData;
import models.User;
import utilities.JsonUtil;

import java.io.IOException;

public class TestDataRunner {
    public static void main(String[] args) throws IOException {
        TestData testdatafromjson = JsonUtil.readTestData();
        testdatafromjson.getUsers().forEach(user -> {
            System.out.println(user.getUsername());
            System.out.println(user.getRole());
        });
    }
}
