package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ProcedimentoBO;
import br.com.start.entity.ProcedimentoEntity;
import br.com.start.facade.ProcedimentoFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ProcedimentoImpl implements Serializable, ProcedimentoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ProcedimentoBO procedimentoBO;

	@Transactional
	@Override
	public void save(ProcedimentoEntity convenio) {
		procedimentoBO.save(convenio);
	}

	@Transactional
	@Override
	public void remove(ProcedimentoEntity convenio) {
		procedimentoBO.remove(convenio);
	}

	@Override
	public List<ProcedimentoEntity> all() {
		return procedimentoBO.all();
	}

	@Override
	public List<ProcedimentoEntity> selected(String value) {
		return procedimentoBO.selected(value);
	}

	@Override
	public ProcedimentoEntity get(Long id) {
		return procedimentoBO.get(id);
	}

}
