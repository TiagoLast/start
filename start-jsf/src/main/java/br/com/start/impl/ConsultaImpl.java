package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ConsultaBO;
import br.com.start.entity.ConsultaEntity;
import br.com.start.facade.ConsultaFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ConsultaImpl implements Serializable, ConsultaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ConsultaBO consultaBO;

	@Transactional
	@Override
	public void save(ConsultaEntity categoria) {
		consultaBO.save(categoria);
	}

	@Transactional
	@Override
	public void remove(ConsultaEntity categoria) {
		consultaBO.remove(categoria);
	}

	@Override
	public List<ConsultaEntity> all() {
		return consultaBO.all();
	}

	@Override
	public List<ConsultaEntity> selected(String value) {
		return consultaBO.selected(value);
	}

	@Override
	public ConsultaEntity get(Long id) {
		return consultaBO.get(id);
	}

}
