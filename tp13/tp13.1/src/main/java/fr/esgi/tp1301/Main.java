package fr.esgi.tp1301;

public class Main {

    public static void main(String[] args) {
        final PackageState state = PackageState.IN_TRANSIT;
        System.out.println(state.ordinal()); //Depends on the order of the enum
        System.out.println(state.getId()); // Do not depend on the order of the enum but the associated identity
    }
}
