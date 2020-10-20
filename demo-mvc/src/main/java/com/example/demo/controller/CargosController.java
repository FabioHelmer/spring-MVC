package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Cargo;
import com.example.demo.service.CargoService;
import com.example.demo.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargosController {

	@Autowired
	CargoService cargoService;

	@Autowired
	DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cargo/cadastro");
		mv.addObject("departamentos", departamentoService.findAll());
		mv.addObject(new Cargo());
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cargo/lista");
		mv.addObject("cargos", cargoService.findAll());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Cargo cargo, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.setViewName("cargo/cadastro");
			mv.addObject(cargo);
		} else {
			mv.setViewName("redirect:/cargos/listar");
			cargoService.save(cargo);
		}

		return mv;
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cargo/alterar");
		mv.addObject(cargoService.findById(id));
		mv.addObject("departamentos", departamentoService.findAll());

		return mv;

	}

	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Cargo cargo, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.setViewName("departamento/alterar");
			mv.addObject(cargo);
		} else {
			mv.setViewName("redirect:/cargos/listar");
			cargoService.update(cargo);
		}
		return mv;
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		cargoService.delete(id);
		mv.setViewName("redirect:/cargos/listar");

		return mv;
	}

}
