package com.morys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.morys.model.Utilisateur;
import com.morys.repository.UtilisateurRepository;



@Controller
@RequestMapping("/utilisateursController")
public class UtilisateurController {
@Autowired
 UtilisateurRepository utilisateurRepository;
@GetMapping("/")
public String index(Model m) {
	List<Utilisateur> utilisateurs=utilisateurRepository.findAll();
 m.addAttribute("utilisateurs", utilisateurs);
 return "utilisateurs/index";
 }
 
} 