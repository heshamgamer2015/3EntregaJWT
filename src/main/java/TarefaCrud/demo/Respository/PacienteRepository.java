package TarefaCrud.demo.Respository;

import TarefaCrud.demo.Entity.Consulta;
import TarefaCrud.demo.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
