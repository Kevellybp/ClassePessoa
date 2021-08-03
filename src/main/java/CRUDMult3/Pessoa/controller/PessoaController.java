package CRUDMult3.Pessoa.controller;


import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import CRUDMult3.Pessoa.model.Pessoa;
import CRUDMult3.Pessoa.repositoy.PessoaRepository;
import CRUDMult3.Pessoa.service.PessoaService;

@RestController
@RequestMapping ("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private PessoaService repositoryS;
	

@GetMapping ( value = "/{id}")
public ResponseEntity<Pessoa> findById (@PathVariable long id){
	Pessoa resp = this.repositoryS.findById(id);
	return ResponseEntity.ok().body(resp);
}

@GetMapping 
public ResponseEntity<List<Pessoa>> getByNome (@PathVariable String nome){
	List<Pessoa> list = repositoryS.findAll();
	return ResponseEntity.ok().body(list);
}
@PostMapping
public ResponseEntity<Pessoa> post(@RequestBody Pessoa obj) {
	Pessoa newObj = repositoryS.post(obj);
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(newObj));
}
@PutMapping (value = "/{id}")
public ResponseEntity<Pessoa> put (@PathVariable Long id, @RequestBody Pessoa obj) {
	Pessoa newObj = repositoryS.put(id, obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
	return ResponseEntity.created(uri).build();
			
}
@DeleteMapping ("/{id}")
public void delete (@PathVariable long id) {
	repository.deleteById(id);
}
}
