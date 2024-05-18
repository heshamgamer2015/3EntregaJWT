package TarefaCrud.demo.Services;

import TarefaCrud.demo.Entity.Endereco;
import TarefaCrud.demo.Respository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServices {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco cadastrar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar (Long id,Endereco endereco){
        if (enderecoRepository.existsById(id)){
            endereco.setId(id);
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    public void deletar (Long id){
        enderecoRepository.deleteById(id);
    }

}