package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ProntuarioBO;
import br.com.start.entity.ProntuarioEntity;
import br.com.start.facade.ProntuarioFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ProntuarioImpl implements Serializable, ProntuarioFacade {

	private static final long serialVersionUID = 2101599288749513604L;
	
	@Inject
	private ProntuarioBO prontuarioBO;

	@Transactional
	@Override
	public void save(ProntuarioEntity prontuario) {
		prontuarioBO.save(prontuario);
	}

	@Transactional
	@Override
	public void remove(ProntuarioEntity prontuario) {
		prontuarioBO.remove(prontuario);
	}

	@Override
	public List<ProntuarioEntity> all() {
		return prontuarioBO.all();
	}

	@Override
	public List<ProntuarioEntity> selected(String value) {
		return prontuarioBO.selected(value);
	}

	@Override
	public ProntuarioEntity get(Long id) {
		return prontuarioBO.get(id);
	}

	@Override
	public List<ProntuarioEntity> recuperaPronturios(Long id) {
		return null;
	}
	

}
