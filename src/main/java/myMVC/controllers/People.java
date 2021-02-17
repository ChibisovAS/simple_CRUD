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
    public String show(Model model, @PathVariable int id) {
        // get 1 person from DAO by ID
        model.addAttribute("person",personFakeDAO.show(id));
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
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("person",personFakeDAO.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable int id) {
        personFakeDAO.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        personFakeDAO.delete(id);
        return "redirect:/people";
    }
}
