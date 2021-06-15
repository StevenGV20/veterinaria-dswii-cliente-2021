package com.veterinaria.cliente.util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FunctionUtil {

	
	public static String toFechaString(Date str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String salida = null;
		try {
			salida = sdf.format(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
	
	public static String toFechaAndHoraString(Date str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String salida = null;
		try {
			salida = sdf.format(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
	
	public static String toHoraString(Date str) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String salida = null;
		try {
			salida = sdf.format(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
}
