package br.com.uri.scopa.controllers;

import java.util.Scanner;

public class Common {
	
	public Scanner scanner = new Scanner(System.in);

	public void invalidValuePrint() {
		System.out.println("Valor inválido, digite novamente: ");
	}

	public boolean isEmptyString(String str) {
		return str.equals("");
	}
}
