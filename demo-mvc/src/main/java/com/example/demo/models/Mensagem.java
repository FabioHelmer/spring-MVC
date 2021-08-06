package com.example.demo.models;

public class Mensagem {

	private String key;
	private String masege;

	public Mensagem(String key, String masege) {
		this.key = key;
		this.masege = masege;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMasege() {
		return masege;
	}

	public void setMasege(String masege) {
		this.masege = masege;
	}

}
