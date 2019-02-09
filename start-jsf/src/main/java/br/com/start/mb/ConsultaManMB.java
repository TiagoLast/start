package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.ConsultaEntity;
import br.com.start.entity.PacienteEntity;
import br.com.start.entity.ProcedimentoEntity;
import br.com.start.facade.ConsultaFacade;
import br.com.start.facade.ICrudMB;
import br.com.start.facade.PacienteFacade;
import br.com.start.facade.ProcedimentoFacade;
import br.com.start.types.Status;

@ViewScoped
@Named
public class ConsultaManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ConsultaFacade consultaFacade;

	@Inject
	private PacienteFacade pacienteFacade;

	@Inject
	private ProcedimentoFacade procedimentoFacade;

	@Inject
	private ConsultaEntity consulta;

	@Inject
	private PacienteEntity paciente;

	private List<PacienteEntity> pacientes;

	@Inject
	private ProcedimentoEntity procedimento;

	private List<ProcedimentoEntity> procedimentos;
	
	
	@PostConstruct
	public void start() {
		pacientes = pacienteFacade.all();
		procedimentos = procedimentoFacade.all();
	}

	@Override
	public void grava() {
		consultaFacade.save(consulta);
		FacesUtil.addInfoMessageInf();
		consulta = new ConsultaEntity();
	}

	public Status[] getStatus() {
		return Status.values();
	}
	
	public ConsultaEntity getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaEntity consulta) {
		this.consulta = consulta;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public ProcedimentoEntity getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoEntity procedimento) {
		this.procedimento = procedimento;
	}

	public List<PacienteEntity> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteEntity> pacientes) {
		this.pacientes = pacientes;
	}

	public List<ProcedimentoEntity> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ProcedimentoEntity> procedimentos) {
		this.procedimentos = procedimentos;
	}
	

}
