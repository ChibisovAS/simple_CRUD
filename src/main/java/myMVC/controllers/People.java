package myMVC.controllers;

import myMVC.dao.PersonFakeDAO;
import myMVC.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class People {
    private final PersonFakeDAO personFakeDAO;

    @Autowired
    public People(PersonFakeDAO personFakeDAO) {
        this.personFakeDAO = personFakeDAO;
    }


    @GetMapping()
    public String index(Model model) {
        // get list of all people from DAO
        model.addAttribute("people",personFakeDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable String id) {
        // get 1 person from DAO by ID
        model.addAttribute("person",personFakeDAO.show(Integer.parseInt(id)));
        return "people/person";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personFakeDAO.save(person);
        return "redirect:/people";
    }
}
