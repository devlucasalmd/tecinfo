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

import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.Client;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.repository.ClientRepository;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.service.ClientService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")

public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;

	@GetMapping
	public List<Client> readAllClient(){
		return clientRepository.findAll();
	}

	@PostMapping
	public Client createClient(@Valid @RequestBody Client client, HttpServletResponse response) {
		return clientRepository.save(client);
	}

	@GetMapping("/{id}")	
	public ResponseEntity<Client> findById(@PathVariable Long id)
	{
		Optional<Client> client = clientRepository.findById(id);

		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());			
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client client){
		Client clientSaved = clientService.findClientById(id);
		return ResponseEntity.ok(clientSaved);
	}
	
}
