package br.com.geovanejuniior.loja.converters;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Calendar.class)
public class CalendarConverter implements Converter {

    private DateTimeConverter converter = new DateTimeConverter();
    ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

    public CalendarConverter() {
    	
        converter.setPattern("dd/MM/yyyy");
//        converter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
//        converter.setTimeZone(zoneId);
    }

    @Override
    public Object getAsObject(FacesContext context, 
            UIComponent component, String dataTexto) {
        Date data = (Date) converter.getAsObject(context, component, dataTexto);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return calendar;
    }

    @Override
    public String getAsString(FacesContext context, 
            UIComponent component, Object dataObject) {
        if (dataObject == null) 
            return null;

        Calendar calendar = (Calendar) dataObject;
        return converter.getAsString(
                context, component, calendar.getTime());
    }

}
