package fr.esgi.tp8;

public class MyObject2 {

    private final MyObjectDependency dependency;

    public MyObject2(MyObjectDependency dependency) {
        this.dependency = dependency;
    }

    public MyObjectDependency getDependency() {
        return dependency;
    }
}
