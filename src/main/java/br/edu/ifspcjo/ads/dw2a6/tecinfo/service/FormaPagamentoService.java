package br.edu.ifspcjo.ads.dw2a6.tecinfo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model.FormaPagamento;
import br.edu.ifspcjo.ads.dw2a6.tecinfo.repository.FormaPagamentoRepository;

public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public FormaPagamento update(Long codigo, FormaPagamento formaPagamento) {
		FormaPagamento formaPagamentoSaved = findFormaPagamentoById(codigo);
		BeanUtils.copyProperties(formaPagamento, formaPagamentoSaved, "codigo");
		return formaPagamentoRepository.save(formaPagamentoSaved);
	}
	
	public FormaPagamento findFormaPagamentoById(Long codigo) {
		FormaPagamento formaPagamentoSaved = formaPagamentoRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return formaPagamentoSaved;
	}
}
