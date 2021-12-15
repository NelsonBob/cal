package fr.esgi.tp1607.use_cases.user.exposition;

import fr.esgi.tp1607.kernel.CommandBus;
import fr.esgi.tp1607.kernel.QueryBus;
import fr.esgi.tp1607.use_cases.user.application.CreateUser;
import fr.esgi.tp1607.use_cases.user.application.RetrieveUsers;
import fr.esgi.tp1607.use_cases.user.domain.Address;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@RestController
public class UserController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public UserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAll() {
        final List<UserResponse> users = queryBus.send(new RetrieveUsers());
        UsersResponse usersResponseResult = new UsersResponse();
        usersResponseResult.users = users;
        return ResponseEntity.ok(usersResponseResult);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody UserRequest request) {
        CreateUser createUser = new CreateUser(request.lastname, request.firstname, new Address(request.address.city));
        commandBus.send(createUser);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
