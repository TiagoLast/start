package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.ConvenioEntity;
import br.com.start.entity.PacienteEntity;
import br.com.start.entity.ProntuarioEntity;
import br.com.start.facade.ConvenioFacade;
import br.com.start.facade.ICrudMB;
import br.com.start.facade.PacienteFacade;
import br.com.start.facade.ProntuarioFacade;

@ViewScoped
@Named
public class PacienteConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PacienteFacade pacienteFacade;

	@Inject
	private ProntuarioFacade prontuarioFacade;

	private PacienteEntity paciente;

	private List<PacienteEntity> pacientes;

	private List<ProntuarioEntity> prontuarios;

	
	@PostConstruct
	public void start() {
		pacientes = pacienteFacade.all();
		recuperaPaciente();
	}

	private void recuperaPaciente() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id)) {
			paciente = pacienteFacade.get(Long.valueOf(id));
			recuperaProntuarios();
		}
	}
	
	public void recuperaProntuarios() {
		if (paciente.getId() !=null) {
			prontuarios = prontuarioFacade.recuperaPronturios(paciente.getId());
		}
		
	}

	public List<PacienteEntity> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteEntity> pacientes) {
		this.pacientes = pacientes;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public List<ProntuarioEntity> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<ProntuarioEntity> prontuarios) {
		this.prontuarios = prontuarios;
	}

	
}
