package TarefaCrud.demo.Respository;

import TarefaCrud.demo.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
}
