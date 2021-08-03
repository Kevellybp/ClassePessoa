package CRUDMult3.Pessoa.repositoy;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CRUDMult3.Pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
public List<Pessoa> findAllByNomeContainingIgnoreCase (String nome);
}
