package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("IBM");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Microsoft");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		
		Banco.lista.add(empresa);
		System.out.println(Banco.lista);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
}
