package fr.esgi.tp8;

import java.util.Optional;

public final class MyObject {

    private MyObjectProperty property;

    public void myMethod(MyObjectDependency dependency) {
        dependency.doExecute();
    }

    public Optional<MyObjectProperty> getProperty() {
        return Optional.ofNullable(property);
    }

    public void setProperty(MyObjectProperty property) {
        this.property = property;
    }
}
