package com.rfboernehave.demo.controller;

import com.rfboernehave.demo.domains.Barn;
import com.rfboernehave.demo.domains.MinBruger;
import com.rfboernehave.demo.services.BarnServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@Controller
public class HomeController {


    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired

    private BarnServiceImpl barnService;


    public HomeController() {
    }


    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index() {
        log.info("index method called...");


        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        log.info("login method called with: ");

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("admin"))) {
            return "redirect:/home";
        }

        return "login";
    }
//
//
   @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
       log.info("home action called...");

       model.addAttribute("boern", barnService.hentAlleBoern());

       log.info("home action ended...");
       return "home";
   }


    @GetMapping("/registrer")
    public String registrer(Model model) {
        log.info("registrer action called...");
        model.addAttribute("barn", new Barn());
        return "registrer";
    }

    @PostMapping("/registrer")
    public String registrer(@ModelAttribute Barn barn, Model model) throws FileNotFoundException {
        log.info("registrer post action called...");
        String home = Integer.toString(barnService.hentAlleBoern().size());
        barn.setId(Integer.parseInt(home));
        barnService.hentAlleBoern().add(barn);
        barnService.printToFile();
        model.addAttribute("boern", barnService.hentAlleBoern());
        return "/home";
    }

    @GetMapping("/detaljer/{id}")
    public String detaljer(@PathVariable("id") int id, Model model) {
        log.info("detaljer action called...");


        Barn lille = null;


        for (Barn barn : barnService.hentAlleBoern()) {
            if (barn.getId() == id) {
                lille = barn;
                break;
            }
        }

        model.addAttribute("barn", lille);
        model.addAttribute("boern", barnService.hentAlleBoern());



        return "detaljer";
    }

    @GetMapping("/afmeld/{id}")
    public String afmeld(@PathVariable("id") int id, Model model) {
        log.info("afmeld  action called...");
        model.addAttribute("barn",barnService.hentAlleBoern().get(id));
        model.addAttribute("boern", barnService.hentAlleBoern());
        return "afmeld";
    }

    @PostMapping("/afmeld")
    public String afmeld(@ModelAttribute Barn barn, Model model) throws FileNotFoundException {
        log.info("afmeld post action called...");
        int id = barn.getId();
        barnService.hentAlleBoern().remove(barn.getId());

        leftShiftId(barnService.hentAlleBoern(), id);
        barnService.printToFile();
        model.addAttribute("boern", barnService.hentAlleBoern());
        return "/home";
    }

    @GetMapping("/rediger/{id}")
    public String rediger(@PathVariable("id") int id, Model model) {
        log.info("rediger action called...");


        model.addAttribute("barn", barnService.hentAlleBoern().get(id));
        model.addAttribute("boern", barnService.hentAlleBoern());
        return "rediger";
    }

    @PostMapping("/rediger")
    public String rediger(@ModelAttribute Barn barn, Model model) throws FileNotFoundException {
        log.info("rediger post action called...");
        for (int i = 0; i < barnService.hentAlleBoern().size(); i++) {
            if (barn.getId() == barnService.hentAlleBoern().get(i).getId()) {
                barnService.hentAlleBoern().set(i, barn);

                break;
            }
        }
        barnService.printToFile();
        model.addAttribute("boern", barnService.hentAlleBoern());
        return "/home";
    }

    private void leftShiftId(ArrayList<Barn> list, int id) {
        log.info("leftshift method called...");
        for (int i = id; i < list.size(); i++) {
            Barn barn = list.get(i);
            barn.setId(barn.getId() - 1);
        }
    }

}
