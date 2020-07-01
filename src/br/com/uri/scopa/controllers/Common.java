package br.com.uri.scopa.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.uri.scopa.models.Card;

public class Common {
	
	public Scanner scanner = new Scanner(System.in);

	public void invalidValuePrint() {
		System.out.println("Valor inválido, digite novamente: ");
	}
	
	public void printCardArray(ArrayList<Card> cards, boolean indexFlag) {
		if(indexFlag) {			
			cards.forEach(el -> el.printCard(cards.indexOf(el) + 1));
		} else {
			cards.forEach(el -> el.printCard());
		}
	}
}
