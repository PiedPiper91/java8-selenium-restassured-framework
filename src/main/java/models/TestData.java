package models;

import java.util.List;

public class TestData {
    private List<User> users;

    public TestData(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
