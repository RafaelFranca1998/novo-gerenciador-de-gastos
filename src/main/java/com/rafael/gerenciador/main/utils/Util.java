package com.rafael.gerenciador.main.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;

/**
 * String Utility Class This is used to encode passwords programmatically
 * @author <a href="mailto:michelmdes@gmail.com">Michel Mendes</a>
 */
public class Util {
    
    
	public final static String PARAM_ALERT_SUCCESS	= "alertSuccessSystem";
    public final static String PARAM_ALERT_INFO		= "alertInfoSystem";
    public final static String PARAM_ALERT_WARNING	= "alertWarningSystem";
    public final static String PARAM_ALERT_DANGER	= "alertDangerSystem";

    

//    /**
//     * Metodo que adiciona no result uma mensagem de alerta tipo SUCCESS, que será mostrada na tela (se a tag de mensagens estiver no jsp)
//     * @param result result da pagina
//     * @param msg mensagem que deseja exibir na tela
//     */
//    public static void setAlertSuccess(Model model, String msg) {
//    	setAlert(model, msg, PARAM_ALERT_SUCCESS);
//    }
//    
//    /**
//     * Metodo que adiciona no result uma mensagem de alerta tipo INFO, que será mostrada na tela (se a tag de mensagens estiver no jsp)
//     * @param result result da pagina
//     * @param msg mensagem que deseja exibir na tela
//     */
//    public static void setAlertInfo(Model model, String msg) {
//    	setAlert(model, msg, PARAM_ALERT_INFO);
//    }
//    
//    /**
//     * Metodo que adiciona no result uma mensagem de alerta tipo WARNING, que será mostrada na tela (se a tag de mensagens estiver no jsp)
//     * @param result result da pagina
//     * @param msg mensagem que deseja exibir na tela
//     */
//    public static void setAlertWarning(Model model, String msg) {
//    	setAlert(model, msg, PARAM_ALERT_WARNING);
//    }
//    
//    /**
//     * Metodo que adiciona no result uma mensagem de alerta de erro tipo DANGER, que será mostrada na tela (se a tag de mensagens estiver no jsp)
//     * @param result result da pagina
//     * @param msg mensagem que deseja exibir na tela
//     */
//    public static void setAlertDanger(Model model, String msg) {
//    	setAlert(model, msg, PARAM_ALERT_DANGER);
//    }
//    
//    private static void setAlert(Model model, String msg, String paranAlert) {
//    	if (model != null && isNotEmpty(msg)) {
//    		ArrayList<AlertSystem> alertList = (ArrayList<AlertSystem>) getModelParam(model, paranAlert);
//    		if (alertList == null) {
//    			alertList = new ArrayList<AlertSystem>();
//    		}
//    		alertList.add(new AlertSystem(msg, null));
//    		model.addAttribute(paranAlert, alertList);
//    	}
//    }
//    
    /**
     * Metodo que retorna o parametro desejado do result atraves do parametro
     * @param result
     * @param nomeParam
     * @return
     */
    public static Object getModelParam(Model model, String nomeParam){
    	Object retorno = null;
    	if (model != null && isNotEmpty(nomeParam)) {
    		Map<String, Object> mapaParam = model.asMap();
    		if (mapaParam != null) {
    			retorno = mapaParam.get(nomeParam);
    		}
    	}
    	return retorno;
    }
    
    /**
     * Método que testa se a String e diferente de null e não vazio
     */
    public static boolean isNotEmpty(String string) {
    	boolean retorno = false;
    	if(string != null && !string.isEmpty()) {
    		retorno = true;
    	}
    	return retorno;
    }
    
    public static boolean isEmpty(String string) {
    	return !isNotEmpty(string);
    }
    
    public static Integer ultimoDiaMes(Integer mes, Integer ano) {
    	Integer ultimoDia = null;
    	if (mes != null) {
	    	Calendar c = Calendar.getInstance();  
	    	c.set(Calendar.MONTH, mes - 1);  
	    	c.set(Calendar.YEAR, ano);    
	    	ultimoDia = c.getActualMaximum(Calendar.DAY_OF_MONTH);
    	}
    	return ultimoDia;
    }
    
    public static String formataData(Date data, String formato) {
    	String dataFormatada = null;
    	SimpleDateFormat formatador = null;
    	if (data != null) {
	    	if (isEmpty(formato)) {
	    		formato = Constants.Date.DATE_PATTERN;
	    	}
    		formatador = new SimpleDateFormat(formato);
    		dataFormatada = formatador.format(data);
    	}
    	return dataFormatada;
    }
    
    public static Date obterData(String data, String formato) throws ParseException {
    	Date dataFormatada = null;
    	SimpleDateFormat formatador = null;
    	if (isEmpty(formato)) {
    		formato = Constants.Date.DATE_PATTERN;
    	}
    	if (data != null) {
			formatador = new SimpleDateFormat(formato);
			dataFormatada = formatador.parse(data);
    	}
    	return dataFormatada;
    }
    
    public static String formataMesAno(Integer mes, Integer ano) {
    	String mesAno = null;
		if (mes != null && ano != null) {
			mesAno = mes + "/" +ano;
			if (mes < 10)
				 mesAno = "0" + mesAno;
		}
		return mesAno;
    }
    
    public static Timestamp currentDate() {
    	return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * Incrementa a data passada por parametro em dia, mes e ano
     * Ex: dataBase = 01/01/2019, dayIncrease = 20, monthIncrease = null, yearIncrease = 2
     * Retorno: 21/01/2011
     * @param date Data base
     * @param dayIncrease Quantidade de dias que serao incrementados na data base 
     * @param monthIncrease Quantidade de meses que serao incrementados na data base
     * @param yearIncrease Quantidade de anos que serao incrementados na data base
     * @return nova data com os incrementos
     */
    public static Timestamp increaseDate(Timestamp date, Integer dayIncrease, Integer monthIncrease, Integer yearIncrease) {
    	Timestamp newDate = null;
    	if (date != null) {
    		Calendar c = Calendar.getInstance();
    		c.setTime(date);

    		if (dayIncrease != null)
    			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + dayIncrease);
    		if (monthIncrease != null)
    			c.set(Calendar.MONTH, c.get(Calendar.MONTH) + monthIncrease);
    		if (yearIncrease != null)
    			c.set(Calendar.YEAR, c.get(Calendar.YEAR) + yearIncrease);

    		newDate = new Timestamp(c.getTimeInMillis());
    	}
    	return newDate;
    }
    
    public static List<String> convertStringToList(String text, String delimiter) {
		List<String> list = null;
		if (text != null && !text.isEmpty()) {
			list = new ArrayList<String>();
			StringTokenizer tokenizer = new StringTokenizer(text, delimiter);
			while (tokenizer.hasMoreTokens()) {
				list.add(tokenizer.nextToken());
			}
		}
		return list;
	}
    
    public static String convertListToString(List<String> list, String delimiter) {
		String text = null;
		if (list != null && !list.isEmpty()) {
			for (String st : list) {
				if (text == null)
					text = "";
				else
					text += delimiter;
				text += st;
			}
		}
		return text;
	}
    
    public static String getInternalizationString(String key) {
    	String locale = LocaleContextHolder.getLocale().toString();//Rafael Franca 06/06/2019 - Obtem a linguagem selecionada pelo usuario 
		ResourceBundle mybundle = ResourceBundle.getBundle("messages_"+locale);//define o caminho da traducao
		return mybundle.getString(key);
    }
    
//    public static String getCronDescription(String seconds, String minutes, String hours, 
//			String dayOfMonth, String month, String dayOfWeek, String year) throws IllegalArgumentException {
//    	
//    	String cron = getCronExpression(seconds, minutes, hours, dayOfMonth, month, dayOfWeek, year);
//    	
//    	//get a predefined instance
//    	CronDefinition cronDefinition =	CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
//
//    	//create a parser based on provided definition
//    	CronParser parser = new CronParser(cronDefinition); // cron = "0 0 10 1,2,3 * ? 2019"
//    	Cron quartzCron = parser.parse(cron);
//
//    	//validate expression
//    	quartzCron.validate();
//    	
//    	//create a descriptor for a specific Locale
//    	CronDescriptor descriptor = CronDescriptor.instance(Locale.US);
//    	//CronDescriptor descriptor = CronDescriptor.instance(new Locale("PT-br"));
//
//    	//parse some expression and ask descriptor for description
//    	String description = descriptor.describe(quartzCron);
//
//    	return description;
//    }
    
    public static String getCronExpression(String seconds, String minutes, String hours, 
			String dayOfMonth, String month, String dayOfWeek, String year) throws IllegalArgumentException {
    	String delimiter = " ";
    	String cron = null;
    	
    	if (isNotEmpty(hours) && isNotEmpty(dayOfMonth) && isNotEmpty(month) && isNotEmpty(dayOfWeek)) {
    		if (isEmpty(seconds)) 
    			seconds = "0";
    		if (isEmpty(minutes)) 
    			minutes = "0";
    		
    		cron = seconds + delimiter + minutes + delimiter + hours + delimiter + dayOfMonth + delimiter 
    				+ month + delimiter + dayOfWeek + delimiter + year;
    		
    	} else {
    		throw new IllegalArgumentException("The parameters hours, dayOfMonth, month, dayOfWeek are mandatory");
    	}
    	
    	return cron;
    }
    
	public static PageRequest getPagination(Integer pageNumber, Integer pageSize, String sortName, String sortOrder){	
		
		/* 
		 * Tratando pageNumber.
		 * O bootstrab table tem primeira pagina 1, e ou pageRequest do Spring tem primeira pagina 0
		 */
		Integer pPageNumber = 0; // Default
		if (pageNumber != null && pageNumber > 0)
			pPageNumber = pageNumber - 1;
		
		/* 
		 * Tratando sortOrder.
		 * Duas opcoes possiveis: ASC e DESC
		 * Padrao: ASC
		 */
		Direction direction = Direction.ASC;
		if (Direction.DESC.name().equalsIgnoreCase(sortOrder))
			direction = Direction.DESC;
		
		/* 
		 * Tratando pageSize.
		 * Padrao: 10
		 */
		Integer pPageSize = 10;
		if (pageSize != null && pageSize > 0) {
			pPageSize = pageSize;
		}
		
		/* 
		 * Tratando sortName.
		 * Padrao: "id"
		 */
		String pSortName = "id";
		if (sortName != null && !sortName.isEmpty()) {
			pSortName = sortName;
		}
		
		PageRequest pageRequest = PageRequest.of(pPageNumber, pPageSize, direction, pSortName);
		
	    return pageRequest;
	}
	
	public static PageRequest getPagination(Integer pageNumber, Integer pageSize){	
		
		/* 
		 * Tratando pageNumber.
		 * O bootstrab table tem primeira pagina 1, e ou pageRequest do Spring tem primeira pagina 0
		 */
		Integer pPageNumber = 0; // Default
		if (pageNumber != null && pageNumber > 0)
			pPageNumber = pageNumber - 1;
		
		/* 
		 * Tratando pageSize.
		 * Padrao: 10
		 */
		Integer pPageSize = 10;
		if (pageSize != null && pageSize > 0) {
			pPageSize = pageSize;
		}
		
		PageRequest pageRequest = PageRequest.of(pPageNumber, pPageSize);
		
	    return pageRequest;
	}
	
	public static Double roundDouble(Double value, int scale) {
		Double val = null;
		if (value != null) {
			BigDecimal bd = new BigDecimal(value).setScale(scale, RoundingMode.HALF_EVEN);
			val = bd.doubleValue();
		}
		return val;
	}
}
