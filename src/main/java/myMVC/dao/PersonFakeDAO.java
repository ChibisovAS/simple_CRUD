package myMVC.dao;

import myMVC.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonFakeDAO {
    private static int PERSON_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person("Kate",++PERSON_ID));
        people.add(new Person("Leo",++PERSON_ID));
        people.add(new Person("Mike",++PERSON_ID));
        people.add(new Person("Tom",++PERSON_ID));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PERSON_ID);
        people.add(person);
    }
}
