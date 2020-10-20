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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Endereco;
import com.example.demo.models.Funcionario;
import com.example.demo.service.CargoService;
import com.example.demo.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	CargoService cargoService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("funcionario/cadastro");
		mv.addObject("cargos", cargoService.findAll());
		mv.addObject(new Funcionario());
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/funcionario/lista");
		mv.addObject("funcionarios", funcionarioService.findAll());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		Endereco endereco = funcionario.getEndereco();

		if (endereco.getCidade().equals("")) {
			result.rejectValue("endereco.cidade", "endereco.cidade", "Cidade é Obrigátorio");
		}
		if (endereco.getLogradouro().equals("")) {
			result.rejectValue("endereco.logradouro", "endereco.logradouro", "Logradouro é Obrigátorio");
		}
		if (endereco.getNumero() == null) {
			result.rejectValue("endereco.numero", "endereco.numero", "Numero é Obrigátorio");
		}

		if (endereco.getBairro().equals("")) {
			result.rejectValue("endereco.bairro", "endereco.bairro", "Bairro é Obrigátorio");
		}

		if (endereco.getUf() == null) {
			result.rejectValue("endereco.uf", "endereco.uf", "UF é Obrigátorio");
		}
		if (endereco.getCep().equals("")) {
			result.rejectValue("endereco.cep", "endereco.cep", "CEP é Obrigátorio");
		}

		if (result.hasErrors()) {
			mv.setViewName("funcionario/cadastro");
			mv.addObject(funcionario);
			mv.addObject(endereco);
		} else {
			mv.setViewName("redirect:/funcionarios/listar");
			funcionarioService.save(funcionario);
		}

		return mv;
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("funcionario/alterar");
		mv.addObject(funcionarioService.findById(id));
		mv.addObject("cargos", cargoService.findAll());

		return mv;

	}

	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Funcionario funcionario, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.setViewName("funcionario/cadastro");
			mv.addObject(funcionario);
		} else {
			mv.setViewName("redirect:/funcionarios/listar");
			funcionarioService.update(funcionario);
		}
		return mv;
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		funcionarioService.delete(id);
		mv.setViewName("redirect:/funcionarios/listar");

		return mv;
	}

	@GetMapping("/buscar/nome")
	public ModelAndView getPorNome(@RequestParam("nome") String nome) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("funcionarios", funcionarioService.buscaPorNome(nome));
		mv.addObject("cargos", cargoService.findAll());
		mv.setViewName("/funcionario/lista");
		return mv;
	}

}
