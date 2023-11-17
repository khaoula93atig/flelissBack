package com.tta.broilers.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class Utils {

	public static final SimpleDateFormat SMPDF = new SimpleDateFormat("dd-MM-yyyy");
	public static final SimpleDateFormat SMPDF4 = new SimpleDateFormat("MM/dd/yyyy");
	public static final String BroilersAgreementsDIR = "C:\\Users\\Khaoula\\Desktop\\projects\\flellis\\fleliss\\fleliss\\attachements\\";
	public static final String RootFolder = "C://Users//EMNA//Documents//broilersWorkspace -new//doc";
	public static final SimpleDateFormat SMPDF2 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat SMPDF3 = new SimpleDateFormat("dd/MM/yyyy");
	public static final String Logo = "C:\\Users\\Khaoula\\Desktop\\projects\\flellis\\fleliss\\fleliss\\attachements\\logoComany";
	public static final String Analyse = "C:\\Users\\Khaoula\\Desktop\\projects\\flellis\\fleliss\\fleliss\\attachements\\analyses";


	public static LocalDate getCreationDate() {
		return new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	}

	public static final String LeftPadString(String arg1, int size, String arg2) {
		return org.apache.commons.lang.StringUtils.leftPad(arg1, size, arg2);
	}

	public static final int GetWeekNbr(int daysNbr) {
		System.out.println("daysNbr***** " + daysNbr);
		double nbrWeeks = (daysNbr / 7)+1;
		System.out.println("nbrWeeks***** " + nbrWeeks);
		return (int) nbrWeeks;
	}

}
