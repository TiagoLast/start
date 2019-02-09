package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.PacienteEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class PacienteBO implements Serializable, AppBO<PacienteEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<PacienteEntity> query;
		
	@Inject
	private PersistenceUtils<PacienteEntity> dao;

	@Override
	public void save(PacienteEntity agenda) {
		dao.save(agenda);
	}

	@Override
	public void remove(PacienteEntity agenda) {
		dao.remove(agenda);
	}

	@Override
	public List<PacienteEntity> all() {
		return query.all(PacienteEntity.class);
	}

	@Override
	public List<PacienteEntity> selected(String value) {
		return query.recuperaItem(PacienteEntity.class, value, "nome");
	}

	@Override
	public PacienteEntity get(Long id) {
		return query.get(PacienteEntity.class, id);
	}

}
