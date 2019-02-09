package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ConsultaEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ConsultaBO implements Serializable, AppBO<ConsultaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<ConsultaEntity> query;
		
	@Inject
	private PersistenceUtils<ConsultaEntity> dao;

	@Override
	public void save(ConsultaEntity consulta) {
		dao.save(consulta);
	}

	@Override
	public void remove(ConsultaEntity consulta) {
		dao.remove(consulta);
	}

	@Override
	public List<ConsultaEntity> all() {
		return query.all(ConsultaEntity.class);
	}

	@Override
	public List<ConsultaEntity> selected(String value) {
		return query.recuperaItem(ConsultaEntity.class, value, "");
	}

	@Override
	public ConsultaEntity get(Long id) {
		return query.get(ConsultaEntity.class, id);
	}

}
