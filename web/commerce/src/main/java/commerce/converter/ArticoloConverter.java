package commerce.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import commerce.model.Articolo;
import commerce.service.ArticoloManager;

@Named("articoloConverter")
public class ArticoloConverter implements Converter {
	@Inject
	ArticoloManager manager;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return manager.get(Integer.valueOf(value));

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Articolo r = (Articolo) value;
		if (r==null) return null;
		String teste = String.valueOf(r.getId());
		return teste;
	}
}