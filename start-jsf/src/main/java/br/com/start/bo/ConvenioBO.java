package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ConvenioEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ConvenioBO implements Serializable, AppBO<ConvenioEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<ConvenioEntity> query;
		
	@Inject
	private PersistenceUtils<ConvenioEntity> dao;
	
	
	@Override
	public void save(ConvenioEntity agenda) {
		dao.save(agenda);
	}

	@Override
	public void remove(ConvenioEntity agenda) {
		dao.remove(agenda);
	}

	@Override
	public List<ConvenioEntity> all() {
		return query.all(ConvenioEntity.class);
	}

	@Override
	public List<ConvenioEntity> selected(String value) {
		return query.recuperaItem(ConvenioEntity.class, value, "nomeConvenio");
	}

	@Override
	public ConvenioEntity get(Long id) {
		return query.get(ConvenioEntity.class, id);
	}

}
