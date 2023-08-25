package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository pr;
	private final CategoriaRepository cr;

	@Autowired
	public DatabaseLoader(
		ProductoRepository pr,
		CategoriaRepository cr
		) {
		this.pr=pr;
		this.cr=cr;
	}

	@Override
	public void run(String... strings) throws Exception {
		Categoria autos=new Categoria("Autos");
		Categoria bicis=new Categoria("Bicicletas");
		Categoria motos=new Categoria("Motos");
		this.cr.save(autos);
		this.cr.save(bicis);
		this.cr.save(motos);
		
		Producto auto1=new Producto("BMV",35000.00f,autos);
		Producto bicis1=new Producto("BMX",4500.00f,bicis);
		Producto motos1=new Producto("Rays",50000.00f,motos);

		this.pr.save(auto1);
		this.pr.save(bicis1);
		this.pr.save(motos1);
	}
}