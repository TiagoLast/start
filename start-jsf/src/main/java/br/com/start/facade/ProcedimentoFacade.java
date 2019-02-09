package br.com.start.facade;

import java.util.List;

import br.com.start.entity.ProcedimentoEntity;

public interface ProcedimentoFacade {

	public void save(ProcedimentoEntity procedimento);

	public List<ProcedimentoEntity> all();

	public void remove(ProcedimentoEntity procedimento);

	public List<ProcedimentoEntity> selected(String value);

	public ProcedimentoEntity get(Long id);

}
