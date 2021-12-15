package fr.esgi.tp1605.use_cases.user.exposition;

import fr.esgi.tp1605.use_cases.user.application.CreateUser;
import fr.esgi.tp1605.use_cases.user.application.CreateUserCommandHandler;
import fr.esgi.tp1605.use_cases.user.application.RetrieveUsers;
import fr.esgi.tp1605.use_cases.user.application.RetrieveUsersHandler;
import fr.esgi.tp1605.use_cases.user.domain.Address;
import fr.esgi.tp1605.use_cases.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class UserController {

    private final CreateUserCommandHandler createUserCommandHandler;
    private final RetrieveUsersHandler retrieveUsersHandler;

    public UserController(CreateUserCommandHandler createUserCommandHandler, RetrieveUsersHandler retrieveUsersHandler) {
        this.createUserCommandHandler = createUserCommandHandler;
        this.retrieveUsersHandler = retrieveUsersHandler;
    }

    @GetMapping(path = "/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAll() {
        final List<User> users = retrieveUsersHandler.handle(new RetrieveUsers());
        UsersResponse usersResponseResult = new UsersResponse();
        usersResponseResult.users = users.stream().map(user -> new UserResponse(String.valueOf(user.getId().getValue()), user.getLastname(), user.getFirstname(), new AddressResponse(user.getAddress().getCity()))).collect(Collectors.toList());
        return ResponseEntity.ok(usersResponseResult);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody UserRequest request) {
        CreateUser createUser = new CreateUser(request.lastname, request.firstname, new Address(request.address.city));
        createUserCommandHandler.handle(createUser);
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
