package com.cimpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cimpa.model.DemandeConge;
import com.cimpa.model.Employe;
import com.cimpa.model.Evenement;


@Controller
public class GRHController {
	
	@Autowired
	private EmployeController empCont; 
	@Autowired
	private EvenementController evCont; 
	@Autowired
	private DemandeCongeController demCont; 
	
	@RequestMapping("/")
	public String viewHomePage() {				
		return "accueil";
	}
	
	//Get de l'Accueil
	@GetMapping("pageEmp")
	public String affichageEmp() {		
		return "pageEmp";
	}
	@GetMapping("pageEv")
	public String affichageEv() {		
		return "pageEv";
	}
	@GetMapping("pageDem")
	public String affichageDem() {		
		return "pageDem";
	}
	@GetMapping("listeEmp")
	public String affichageListe() {		
		return "listeEmp";
	}
	
	//Page X affichage liste
	@RequestMapping("/pageEmp")
	public String AffPageEmp(Model model) {
		List<Employe> listEmp = empCont.listerEmp();		
		model.addAttribute("listEmp", listEmp);			
		return "pageEmp";
	}
	
	@RequestMapping("/pageEv")
	public String AffPageEv(Model model) {
		List<Evenement> listEv = evCont.listerEv();
		model.addAttribute("listEv", listEv);		
		return "pageEv";
	}
	@RequestMapping("/pageDem")
	public String AffPageDem(Model model) {
		List<DemandeConge> listDem = demCont.listerDemC();
		model.addAttribute("listDem", listDem);		
		return "pageDem";
	}
	
	//essai liste
	@RequestMapping("/listeEmp")	
	public String AfflistEmp(Model model) {
		List<Employe> listEmp = new ArrayList<Employe>();
		listEmp = empCont.listerEmp();		
		model.addAttribute("listEmp", listEmp);			
		return "listeEmp";
	}
		
	//Crea+redirection page X
	@RequestMapping("/newEmp")
	public String AffNewEmp(Model model) {
		Employe emp = new Employe();
		model.addAttribute("employe", emp);		
		return "newEmp";
	}
	@RequestMapping("/newEv")
	public String AffNewEv(Model model) {
		Evenement ev = new Evenement();
		model.addAttribute("evenement", ev);		
		return "newEv";
	}
	@RequestMapping("/newDem")
	public String AffNewDem(Model model) {
		DemandeConge dem = new DemandeConge();
		model.addAttribute("demande", dem);		
		return "newDem";
	}
	
	//Creation objet X
	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST) 
	public String saveEmp(@ModelAttribute("employe") Employe emp) {
		empCont.save(emp);		
		return "redirect:/pageEmp";
	}
	@RequestMapping(value = "/saveEv", method = RequestMethod.POST) 
	public String saveEv(@ModelAttribute("evenement") Evenement ev) {
		evCont.save(ev);		
		return "redirect:/pageEv";
	}
	@RequestMapping(value = "/saveDem", method = RequestMethod.POST) 
	public String saveDemande(@ModelAttribute("demande") DemandeConge dem) {
		demCont.save(dem);		
		return "redirect:/pageDem";
	}
	
	
	//Update par id
	@RequestMapping("/editEmp/{id}")
	public ModelAndView showEditEmpPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editEmp");
		Employe emp = empCont.get(id);
		mav.addObject("employe", emp);		
		return mav;
	}
	@RequestMapping("/editEv/{id}")
	public ModelAndView showEditEvPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editEv");
		Evenement ev = evCont.get(id);
		mav.addObject("evenement", ev);		
		return mav;
	}
	@RequestMapping("/editDem/{id}")
	public ModelAndView showEditDemPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editDem");
		DemandeConge dem = demCont.get(id);
		mav.addObject("demande", dem);		
		return mav;
	}
		
	
	//suppression objet
	@RequestMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable(name = "id") int id) {
		empCont.delete(id);
		return "redirect:/pageEmp";	// retourner à la page racine	
	}
	@RequestMapping("/deleteEv/{id}")
	public String deleteEv(@PathVariable(name = "id") int id) {
		evCont.delete(id);
		return "redirect:/pageEv";	// retourner à la page racine	
	}
	@RequestMapping("/deleteDem/{id}")
	public String deleteDem(@PathVariable(name = "id") int id) {
		demCont.delete(id);
		return "redirect:/pageDem";	// retourner à la page racine	
	}
	
}
