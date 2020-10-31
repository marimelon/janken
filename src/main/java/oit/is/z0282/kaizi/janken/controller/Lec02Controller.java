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
import oit.is.z0282.kaizi.janken.model.UserMapper;
import oit.is.z0282.kaizi.janken.model.MatchMapper;
import oit.is.z0282.kaizi.janken.model.Match;
import oit.is.z0282.kaizi.janken.model.MatchInfoMapper;
import oit.is.z0282.kaizi.janken.model.MatchInfo;

@Controller
@RequestMapping
public class Lec02Controller {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

  @GetMapping("/lec02")
  public String lec2_get(@RequestParam(required = false) Optional<String> hand, Principal prin, ModelMap model) {
    hand.ifPresent(val -> {
      Janken janken = new Janken(val);
      model.addAttribute("phand", val);
      model.addAttribute("chand", janken.getCpuHand());
      model.addAttribute("result", janken.getResult());
    });

    var users = userMapper.selectAllUsers();
    model.addAttribute("users", users);

    var matches = matchMapper.selectAllMatches();
    model.addAttribute("matches", matches);

    return "lec02.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam int id, Principal prin, ModelMap model) {
    var user = userMapper.selectUsersByName(prin.getName()).get(0);

    var opponent = userMapper.selectUserById(id);
    model.addAttribute("opponent", opponent);

    var match_info = new MatchInfo();
    match_info.setUser_1(user.getId());
    match_info.setUser_2(opponent.getId());
    match_info.setIs_active(true);
    matchInfoMapper.insertMatchInfo(match_info);

    return "match.html";
  }

  @GetMapping("/result")
  public String result(@RequestParam int id, @RequestParam String hand, Principal prin, ModelMap model) {
    var user = userMapper.selectUsersByName(prin.getName()).get(0);

    var opponent = userMapper.selectUserById(id);
    model.addAttribute("opponent", opponent);

    Janken janken = new Janken(hand);
    model.addAttribute("phand", hand);
    model.addAttribute("chand", janken.getCpuHand());
    model.addAttribute("result", janken.getResult());

    var match = new Match();
    match.setUser_1(user.getId());
    match.setUser_2(opponent.getId());
    match.setUser_1_hand(hand);
    match.setUser_2_hand(janken.getCpuHand());
    matchMapper.insertChamber(match);

    return "match.html";
  }
}
