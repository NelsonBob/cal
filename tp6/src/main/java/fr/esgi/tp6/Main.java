package fr.esgi.tp6;

import fr.esgi.tp6.assembly.MyBusinessServiceProxyFactory;

public class Main {

    public static void main(String[] args) {
        var authenticationService = new MyAuthenticationService();
        var myBusinessServiceProxyFactory = new MyBusinessServiceProxyFactory(authenticationService);
        var proxyBusinessService = myBusinessServiceProxyFactory.get();
        proxyBusinessService.doSomething();
    }
}
