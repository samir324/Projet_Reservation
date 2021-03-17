package org.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.example.service.EtudiantService;
import org.example.service.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	@Autowired
	private EtudiantService etudiantService;


	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response, ModelMap modelMap) throws IOException, ClassNotFoundException, SQLException{
		modelMap.put("etudiants", etudiantService.findAll());
		return new ModelAndView("test");
	}
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public String index(ModelMap modelMap) throws ClassNotFoundException, SQLException {
//		modelMap.put("etudiants", etudiantService.findAll());
//		return "test";
//	}
}
