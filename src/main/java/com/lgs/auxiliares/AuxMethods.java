package com.lgs.auxiliares;

public class AuxMethods {

	public static Double convertToDouble(String StrNumber) {
		if (StrNumber == null) {
			return 0D;
		}
		String number = StrNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}


}
