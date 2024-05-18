package TarefaCrud.demo.Controller;

import TarefaCrud.demo.Entity.Paciente;
import TarefaCrud.demo.Services.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/paciente")
public class PacienteController {

    @Autowired
    private PacienteServices services;

    @GetMapping("/lista")
    public ResponseEntity<List<Paciente>> findAll() {
        try {
            return ResponseEntity.ok(services.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarPaciente(@RequestBody Paciente paciente) {
        try {
            Paciente novoPaciente = services.cadastrar(paciente);
            return ResponseEntity.ok("Paciente cadastrado com Sucesso");
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        try {
            Paciente pacienteAtalizado = services.atualizar(id, paciente);
            if ( pacienteAtalizado!= null) {
                return ResponseEntity.ok("Paciente atualizado com Sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPaciente(@PathVariable Long id) {
        try {
            services.deletar(id);
            return ResponseEntity.ok("Paciente deletado com sucesso");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
