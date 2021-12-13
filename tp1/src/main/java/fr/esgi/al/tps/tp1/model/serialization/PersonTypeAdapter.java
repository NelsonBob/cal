package fr.esgi.al.tps.tp1.model.serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.esgi.al.tps.tp1.model.Person;

import java.io.IOException;

public final class PersonTypeAdapter extends TypeAdapter<Person> {

    @Override
    public void write(JsonWriter writer, Person person) throws IOException {
        writer.beginObject();

        writer.name("lastname").value(person.getLastname());
        writer.name("firstname").value(person.getFirstname());
        writer.name("age").value(person.getAge());

        var optionalAddress = person.getAddress();
        if (optionalAddress.isPresent()) {
            var address = optionalAddress.get();
            writer.name("number").value(address.getNumber());
            writer.name("street").value(address.getStreet());
            writer.name("city").value(address.getCity());
        }
        writer.endObject();
    }

    @Override
    public Person read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
