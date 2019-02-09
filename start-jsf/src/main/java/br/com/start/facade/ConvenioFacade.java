package br.com.start.facade;

import java.util.List;

import br.com.start.entity.ConvenioEntity;

public interface ConvenioFacade {

	public void save(ConvenioEntity convenio);

	public List<ConvenioEntity> all();

	public void remove(ConvenioEntity convenio);

	public List<ConvenioEntity> selected(String value);

	public ConvenioEntity get(Long id);

}
