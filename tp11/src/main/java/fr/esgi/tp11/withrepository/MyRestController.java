package fr.esgi.tp11.withrepository;

import fr.esgi.tp11.User;

public class MyRestController {

    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    public void createFromRequest(User user) {
        userService.createUser(user);
    }
}
