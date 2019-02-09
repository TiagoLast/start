package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.PacienteBO;
import br.com.start.entity.PacienteEntity;
import br.com.start.facade.PacienteFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class PacienteImpl implements Serializable, PacienteFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private PacienteBO pacienteBO;

	@Transactional
	@Override
	public void save(PacienteEntity paciente) {
		pacienteBO.save(paciente);
	}

	@Transactional
	@Override
	public void remove(PacienteEntity paciente) {
		pacienteBO.remove(paciente);
	}

	@Override
	public List<PacienteEntity> all() {
		return pacienteBO.all();
	}

	@Override
	public List<PacienteEntity> selected(String value) {
		return pacienteBO.selected(value);
	}

	@Override
	public PacienteEntity get(Long id) {
		return pacienteBO.get(id);
	}

}
