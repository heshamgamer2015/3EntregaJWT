package TarefaCrud.demo.Controller;

import TarefaCrud.demo.Entity.Endereco;
import TarefaCrud.demo.Services.EnderecoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping ("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServices services;

    @GetMapping("/lista")
    public ResponseEntity<List<Endereco>> findAll() {
        try {
            return ResponseEntity.ok(services.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarEndereco(@RequestBody Endereco endereco) {
        try {
            Endereco novoEndereco = services.cadastrar(endereco);
            return ResponseEntity.ok("Endereco cadastrado com Sucesso");
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        try {
            Endereco enderecoAtalizado = services.atualizar(id, endereco);
            if ( enderecoAtalizado!= null) {
                return ResponseEntity.ok("Endereco atualizado com Sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerEndereco(@PathVariable Long id) {
        try {
            services.deletar(id);
            return ResponseEntity.ok("Endereco deletado com sucesso");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
