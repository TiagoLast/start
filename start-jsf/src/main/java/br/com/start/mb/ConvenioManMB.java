package br.com.start.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.ConvenioEntity;
import br.com.start.facade.ConvenioFacade;
import br.com.start.facade.ICrudMB;

@ViewScoped
@Named
public class ConvenioManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ConvenioFacade convenioFacade;

	@Inject
	private ConvenioEntity convenio;

	
	@Override
	public void grava() {
		try {
			convenioFacade.save(convenio);
			FacesUtil.addInfoMessageInf();
			this.convenio = new ConvenioEntity();
		} catch (Exception e) {
			FacesUtil.addErrorMessageFatal("Erro " + e.getMessage());
		}
	}
	
	private void recuperaConvenio() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.convenio = convenioFacade.get(Long.valueOf(id));
		}
	}


	public ConvenioEntity getConvenio() {
		return convenio;
	}

	public void setConvenio(ConvenioEntity convenio) {
		this.convenio = convenio;
	}

}
