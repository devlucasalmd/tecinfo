package br.edu.ifspcjo.ads.dw2a6.tecinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.FormaPagamento;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.repository.FormaPagamentoRepository;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.service.FormaPagamentoService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/formaPagamento")

public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@GetMapping
	public List<FormaPagamento> getAllFormaPagamento(){
		return formaPagamentoRepository.findAll();
	}
	
	@PostMapping
	public FormaPagamento create(@RequestBody FormaPagamento formaPagamento, HttpServletResponse response) {
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> findById(@PathVariable Long codigo){
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(codigo);
		if(formaPagamento.isPresent()) {
			return ResponseEntity.ok(formaPagamento.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long codigo) {
		formaPagamentoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FormaPagamento> update(@PathVariable Long codigo, @RequestBody FormaPagamento formaPagamento){
		FormaPagamento formaPagamentoSaved = formaPagamentoService.update(codigo, formaPagamento);
		return ResponseEntity.ok(formaPagamentoSaved);
	}
	
}
