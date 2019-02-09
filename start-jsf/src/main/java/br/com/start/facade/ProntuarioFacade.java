package br.com.start.facade;

import java.util.List;

import br.com.start.entity.ProntuarioEntity;

public interface ProntuarioFacade {
	
	public void save(ProntuarioEntity prontuario);
	
	public List<ProntuarioEntity> all();

	public void remove(ProntuarioEntity prontuario);

	public List<ProntuarioEntity> selected(String value);
	
	public List<ProntuarioEntity> recuperaPronturios(Long id);
	
	public ProntuarioEntity get(Long id);

}
