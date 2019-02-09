package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ConvenioBO;
import br.com.start.entity.ConvenioEntity;
import br.com.start.facade.ConvenioFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ConvenioImpl implements Serializable, ConvenioFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ConvenioBO convenioBO;

	@Transactional
	@Override
	public void save(ConvenioEntity convenio) {
		convenioBO.save(convenio);
	}

	@Transactional
	@Override
	public void remove(ConvenioEntity convenio) {
		convenioBO.remove(convenio);
	}

	@Override
	public List<ConvenioEntity> all() {
		return convenioBO.all();
	}

	@Override
	public List<ConvenioEntity> selected(String value) {
		return convenioBO.selected(value);
	}

	@Override
	public ConvenioEntity get(Long id) {
		return convenioBO.get(id);
	}

}
