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

import com.example.demo.models.Departamento;
import com.example.demo.models.Mensagem;
import com.example.demo.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("departamento/cadastro");
		mv.addObject("departamento", new Departamento());

		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/departamento/lista");
		mv.addObject("departamentos", departamentoService.findAll());
		Mensagem msg = new Mensagem("", "Não pode excluido, pois esse registro esta em uso");
		mv.addObject("msg", msg);
		return mv;
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Departamento departamento = departamentoService.findById(id);
		mv.setViewName("departamento/alterar");
		mv.addObject(departamento);

		return mv;

	}

	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Departamento departamento, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.setViewName("departamento/alterar");
			mv.addObject(departamento);
		} else {
			mv.setViewName("redirect:/departamentos/listar");
			departamentoService.update(departamento);
		}
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Departamento departamento, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.setViewName("departamento/cadastro");
			mv.addObject(departamento);
		} else {
			mv.setViewName("redirect:/departamentos/listar");
			departamentoService.save(departamento);
		}

		return mv;
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		boolean excluir = departamentoService.verificaAssociacaoCargos(id);
		if (excluir) {
			departamentoService.delete(id);
			mv.setViewName("redirect:/departamentos/listar");
		} else {
			mv.setViewName("/departamento/lista");
			Mensagem msg = new Mensagem("erro", "Não pode excluido, pois esse registro esta em uso");
			mv.addObject("msg", msg );
			mv.addObject("departamentos", departamentoService.findAll());
		}

		return mv;
	}

}
