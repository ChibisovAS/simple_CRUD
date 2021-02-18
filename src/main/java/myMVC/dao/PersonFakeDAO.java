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

        people.add(new Person(++PERSON_ID,"Kate",20,"kate@mail.ru"));
        people.add(new Person(++PERSON_ID,"Leo",21,"leo@mail.ru"));
        people.add(new Person(++PERSON_ID,"Mike",22,"mike@mail.ru"));
        people.add(new Person(++PERSON_ID,"Tom",23,"tom@mail.ru"));
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

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(x -> x.getId() == id);
    }
}
