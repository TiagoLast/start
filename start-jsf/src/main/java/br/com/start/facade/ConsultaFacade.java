package br.com.start.facade;

import java.util.List;

import br.com.start.entity.ConsultaEntity;

public interface ConsultaFacade {
	
	public void save(ConsultaEntity consulta);
	
	public List<ConsultaEntity> all();

	public void remove(ConsultaEntity consulta);

	public List<ConsultaEntity> selected(String value);

	public ConsultaEntity get(Long id);

}
