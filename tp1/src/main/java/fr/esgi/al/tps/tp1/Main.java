package fr.esgi.al.tps.tp1;

import fr.esgi.al.tps.tp1.model.Address;
import fr.esgi.al.tps.tp1.model.Person;
import fr.esgi.al.tps.tp1.model.serialization.PersonTypeAdapter;
import fr.esgi.al.tps.tp1.service.SerializationEngineFactory;

public final class Main {

    public static void main(String[] args) {

        var address = Address.of(3, "ECLUSE", "ALFORTVILLE");
        //var person = Person.withNoAddress("BOISSINOT", "GREGORY", 20);
        var person = Person.withAddress("BOISSINOT", "GREGORY", 20, address);

        var serializationEngine = SerializationEngineFactory.withJSONSerialization(Person.class, new PersonTypeAdapter());
        var jsonEncoded = serializationEngine.apply(person);
        System.out.println(jsonEncoded);
    }
}
