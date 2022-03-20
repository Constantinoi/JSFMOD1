package br.com.cursojsf;

import javax.persistence.Persistence;

public class TesteJpa {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("jsfmod1");
	}
}
