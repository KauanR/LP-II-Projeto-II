package br.com.uri.scopa.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.uri.scopa.models.Card;

public class Common {
	
	public Scanner scanner = new Scanner(System.in);

	public void invalidValuePrint() {
		System.out.println("Valor inválido, digite novamente: ");
	}

	public boolean isEmptyString(String str) {
		return str.equals("");
	}
	
	public void printCardArray(ArrayList<Card> cards) {
		for(Card card : cards) {
			card.printCard(cards.indexOf(card) + 1);
		}
	}
}
