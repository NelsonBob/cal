package fr.esgi.tp3;

class Main {
    public static void main(String[] args) {
        Bar bar = new Bar();

        Foo foo = new ChildFoo();
        bar.bar(foo);
    }
}
