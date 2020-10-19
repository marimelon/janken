package oit.is.z0282.kaizi.janken.controller;

import java.security.Principal;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oit.is.z0282.kaizi.janken.model.Janken;
import oit.is.z0282.kaizi.janken.model.Entry;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  @Autowired
  private Entry entry;

  @GetMapping
  public String get(@RequestParam(required = false) Optional<String> hand,Principal prin, ModelMap model) {
    hand.ifPresent(val -> {
      Janken janken = new Janken(val);
      model.addAttribute("phand", val);
      model.addAttribute("chand", janken.getCpuHand());
      model.addAttribute("result", janken.getResult());
    });

    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);

    return "lec02.html";
  }

  @PostMapping
  public String post(RedirectAttributes redirectAttributes, @RequestParam String name, ModelMap model) {
    redirectAttributes.addFlashAttribute("name", name);
    return "redirect:/lec02";
  }
}
