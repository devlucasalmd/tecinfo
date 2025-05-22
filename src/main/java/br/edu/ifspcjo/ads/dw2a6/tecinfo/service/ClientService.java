package br.edu.ifspcjo.ads.dw2a6.tecinfo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.Client;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client update(Long id, Client client) {
		Client clientSaved = findClientById(id);
		BeanUtils.copyProperties(client, clientSaved, "id");
		return clientRepository.save(clientSaved);
	}
	
	public Client findClientById(Long id) {
		Client clientSaved = clientRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return clientSaved;
	}
}
