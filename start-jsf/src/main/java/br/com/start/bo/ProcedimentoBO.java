package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ProcedimentoEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ProcedimentoBO implements Serializable, AppBO<ProcedimentoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<ProcedimentoEntity> dao;
	
	@Inject
	private QueryUtils<ProcedimentoEntity> query;
	

	@Override
	public void save(ProcedimentoEntity procedimento) {
		dao.save(procedimento);
	}

	@Override
	public void remove(ProcedimentoEntity procedimento) {
		dao.remove(procedimento);
	}

	@Override
	public List<ProcedimentoEntity> all() {
		return query.all(ProcedimentoEntity.class);
	}

	@Override
	public List<ProcedimentoEntity> selected(String value) {
		return query.recuperaItem(ProcedimentoEntity.class, value, "tipoProcedimento");
	}

	@Override
	public ProcedimentoEntity get(Long id) {
		return query.get(ProcedimentoEntity.class, id);
	}

}
