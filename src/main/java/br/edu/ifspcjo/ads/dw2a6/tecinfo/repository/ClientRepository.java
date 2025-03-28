package br.edu.ifspcjo.ads.dw2a6.tecinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
