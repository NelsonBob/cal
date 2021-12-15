package fr.esgi.tp1607.use_cases.user.exposition;

import fr.esgi.tp1607.kernel.QueryBus;
import fr.esgi.tp1607.use_cases.user.application.RetrieveUsers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@RestController
public class UserController {

    private final QueryBus queryBus;

    public UserController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersDTO> getAll() {
        final List<UserDTO> users = queryBus.send(new RetrieveUsers());
        UsersDTO usersDTOResult = new UsersDTO();
        usersDTOResult.users = users;
        return ResponseEntity.ok(usersDTOResult);
    }
}
