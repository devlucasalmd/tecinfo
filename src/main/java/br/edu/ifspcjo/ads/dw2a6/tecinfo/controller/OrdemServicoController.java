package br.edu.ifspcjo.ads.dw2a6.tecinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.dw2a6.tecinfo.repository.OrdemServicoRepository;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.service.OrdemServicoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.FormaPagamento;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.OrdemServico;

@RestController
@RequestMapping("/ordem")

public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@GetMapping
	public List<OrdemServico> readAllOrdemServico(){
		return ordemServicoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico createOrdemServico(@Valid @RequestBody OrdemServico ordemServico, HttpServletResponse response) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServico> findById(@PathVariable Long codigo){
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(codigo);
		if(ordemServico.isPresent()) {
			return ResponseEntity.ok(ordemServico.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long codigo) {
		ordemServicoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico> update(@PathVariable Long codigo, @RequestBody OrdemServico ordemServico){
		OrdemServico ordemServicoSaved = ordemServicoService.update(codigo, ordemServico);
		return ResponseEntity.ok(ordemServicoSaved);
	}
	
}
