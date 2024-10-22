package ru.donkan.springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.donkan.springCrud.dao.WalletDAO;
import ru.donkan.springCrud.models.Person;
import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class WalletController {

    private final WalletDAO walletDAO;

    @Autowired
    public WalletController(WalletDAO walletDAO) {
        this.walletDAO = walletDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", walletDAO.index());
        return "people/index";
    }

    @GetMapping("/{uuid}")
    public String show(@PathVariable("uuid") int uuid, Model model) {
        model.addAttribute("person", walletDAO.show(uuid));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        walletDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{uuid}/edit")
    public String edit(Model model, @PathVariable("uuid") int uuid) {
        model.addAttribute("person", walletDAO.show(uuid));
        return "people/edit";
    }

    @PatchMapping("/{uuid}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("uuid") int uuid) {
        if (bindingResult.hasErrors())
            return "people/edit";

        walletDAO.update(uuid, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{uuid}")
    public String delete(@PathVariable("uuid") int uuid) {
        walletDAO.delete(uuid);
        return "redirect:/people";
    }
}
