package CRUDMult3.Pessoa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CRUDMult3.Pessoa.model.Pessoa;
import CRUDMult3.Pessoa.repositoy.PessoaRepository;

@SpringBootApplication
public class PessoaApplication implements CommandLineRunner  {

	@Autowired
	private PessoaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
		System.out.println("Deu certo");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(0, "Kevelly", 23, "kevelly133@gmail.com");
		Pessoa p2 = new Pessoa(1, "Rodrigo", 27, "rodrigo@gmail.com");
		
		repository.saveAll(Arrays.asList(p1,p2));
	}

	
}
