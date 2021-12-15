package fr.esgi.tp1605.use_cases.user.exposition;

import fr.esgi.tp1605.use_cases.user.application.RetrieveUsers;
import fr.esgi.tp1605.use_cases.user.application.RetrieveUsersHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@RestController
public class UserController {

    private final RetrieveUsersHandler retrieveUsersHandler;

    @Autowired
    private UserController(RetrieveUsersHandler retrieveUsersHandler) {
        this.retrieveUsersHandler = retrieveUsersHandler;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersDTO> getAll() {
        final List<UserDTO> users = retrieveUsersHandler.handle(new RetrieveUsers());
        UsersDTO usersDTOResult = new UsersDTO();
        usersDTOResult.users = users;
        return ResponseEntity.ok(usersDTOResult);
    }
}
