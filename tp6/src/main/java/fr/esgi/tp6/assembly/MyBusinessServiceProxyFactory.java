package fr.esgi.tp6.assembly;

import fr.esgi.tp6.MyAuthenticationService;
import fr.esgi.tp6.MyBusinessService;

import java.util.function.Supplier;

public class MyBusinessServiceProxyFactory implements Supplier<MyBusinessService> {

    private final MyAuthenticationService authenticationService;

    public MyBusinessServiceProxyFactory(MyAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public MyBusinessService get() {
        return new MyBusinessServiceProxy(authenticationService);
    }
}
