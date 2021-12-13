package fr.esgi.tp8;

public class Main2 {

    public static void main(String[] args) {
        MyObject2 myObject2 = new MyObject2(new NullMyObjectDependency());

        final MyObjectDependency dependency = myObject2.getDependency();
        if (dependency instanceof NullMyObjectDependency) {
            System.out.println("Dependency is absent.");
        }
    }
}
