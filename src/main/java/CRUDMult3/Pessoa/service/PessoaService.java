package CRUDMult3.Pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CRUDMult3.Pessoa.model.Pessoa;
import CRUDMult3.Pessoa.repositoy.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public Pessoa findById (Long id) {
		Optional<Pessoa> resp =repository.findById(id);
		return resp.orElse(null);
	}
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa put (Long id, Pessoa obj) {
		Pessoa newObj = findById (id);
		newObj.setNome(obj.getNome());
		newObj.setIdade(obj.getIdade());
		newObj.setEmail(obj.getEmail());
		return repository.save(newObj);
	}
	public Pessoa post (Pessoa obj) {
		obj.setId(0);
		return repository.save(obj);
	}
}
