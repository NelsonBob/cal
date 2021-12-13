package fr.esgi.demo.cours.demo1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<UserId, User> map = new HashMap<>();

        final UserId userId1 = UserId.of("1");
        final User user1 = new User(userId1, "NAME1");
        map.put(userId1, user1);

        final UserId searchUserId = UserId.of("1");

        System.out.println(userId1 == searchUserId);
        System.out.println("Equals:" + userId1.equals(searchUserId));
        final User user = map.get(searchUserId);
        System.out.println(user);
    }
}
