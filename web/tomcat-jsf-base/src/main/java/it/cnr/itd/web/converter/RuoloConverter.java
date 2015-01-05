package it.cnr.itd.web.converter;

import it.cnr.itd.web.business.RuoliManager;
import it.cnr.itd.web.model.Ruolo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named("ruoloConverter")
public class RuoloConverter implements Converter {
	@Inject
	RuoliManager manager;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return manager.getRuolo(Integer.valueOf(value));

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Ruolo r = (Ruolo) value;
		if (r==null) return null;
		String teste = String.valueOf(r.getId());
		return teste;
	}
}