package TarefaCrud.demo.Services;

import TarefaCrud.demo.Entity.Paciente;
import TarefaCrud.demo.Respository.PacienteRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
public class PacienteServices {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente cadastrar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar (Long id,Paciente paciente){
        if (pacienteRepository.existsById(id)){
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public void deletar (Long id){
        pacienteRepository.deleteById(id);
    }
}