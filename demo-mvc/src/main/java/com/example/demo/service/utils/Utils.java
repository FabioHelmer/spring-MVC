package com.example.demo.service.utils;

import java.util.UUID;

public class Utils {

	public static String UUID() {
		return UUID.randomUUID().toString();
	}

	public static String zeroExquerda(int max) {
		String codigo = String.valueOf(max);
		return String.format("%1$" + 4 + "s", codigo).replaceAll(" ", "0");
	}
}
