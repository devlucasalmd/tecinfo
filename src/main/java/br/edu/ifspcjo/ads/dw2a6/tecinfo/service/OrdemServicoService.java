package br.edu.ifspcjo.ads.dw2a6.tecinfo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.OrdemServico;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServico update(Long codigo, OrdemServico ordemServico) {
		OrdemServico ordemServicoSaved = findOrdemServicoById(codigo);
		BeanUtils.copyProperties(ordemServico, ordemServicoSaved, "codigo");
		return ordemServicoRepository.save(ordemServicoSaved);
	}
	
	public OrdemServico findOrdemServicoById(Long codigo) {
		OrdemServico ordemServicoSaved = ordemServicoRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ordemServicoSaved;
	}
}
