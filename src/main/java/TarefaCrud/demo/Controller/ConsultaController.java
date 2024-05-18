package TarefaCrud.demo.Controller;

import TarefaCrud.demo.Entity.Consulta;
import TarefaCrud.demo.Services.ConsultaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/consulta")

public class ConsultaController {

    @Autowired
    private ConsultaServices services;

    @GetMapping("/lista")
    public ResponseEntity<List<Consulta>> findAll() {
        try {
            return ResponseEntity.ok(services.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarEndereco(@RequestBody Consulta consulta) {
        try {
            Consulta novoConsulta = services.cadastrar(consulta);
            return ResponseEntity.ok("Consulta cadastrado com Sucesso");
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        try {
            Consulta consultaAtalizado = services.atualizar(id, consulta);
            if ( consultaAtalizado!= null) {
                return ResponseEntity.ok("Consulta atualizado com Sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerConsulta(@PathVariable Long id) {
        try {
            services.deletar(id);
            return ResponseEntity.ok("Consulta deletado com sucesso");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
