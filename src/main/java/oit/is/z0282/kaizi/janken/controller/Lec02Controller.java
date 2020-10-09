package oit.is.z0282.kaizi.janken.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oit.is.z0282.kaizi.janken.model.Janken;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {
  @GetMapping
  public String get(@RequestParam(required = false) Optional<String> hand, ModelMap model) {
    hand.ifPresent(val -> {
      Janken janken = new Janken(val);
      model.addAttribute("phand", val);
      model.addAttribute("chand", janken.getCpuHand());
      model.addAttribute("result", janken.getResult());
    });
    return "lec02.html";
  }

  @PostMapping
  public String post(RedirectAttributes redirectAttributes, @RequestParam String name, ModelMap model) {
    redirectAttributes.addFlashAttribute("name", name);
    return "redirect:/lec02";
  }
}
