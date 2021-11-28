package main;

import java.io.FileNotFoundException;

import Layer.Analyse;
import decodeur_texte.Decodeur;
import decodeur_texte.ListeTrames;

public class Launcher {

	public static void main(String[] args) throws FileNotFoundException {
		String path =  "data/trames_analyse/trame_DNS_2_answers.txt"; // TODO prendre path depuis args
		ListeTrames trames = Decodeur.getListTrames(path);
		for(int i = 0 ; i < trames.getNbTrames() ; i++) {
			System.out.println("Trame " + (i+1));
			Analyse.analyse(trames.getTrame(i)); // Analyse de chaque trame
			System.out.print("\n\n"); // Saut lignes entre analyses
		}
	}
}
