package TarefaCrud.demo.Services;

import TarefaCrud.demo.Entity.Consulta;
import TarefaCrud.demo.Respository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServices {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public Consulta cadastrar(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta atualizar (Long id,Consulta consulta){
        if (consultaRepository.existsById(id)){
            consulta.setId(id);
            return consultaRepository.save(consulta);
        }
        return null;
    }

    public void deletar (Long id){
        consultaRepository.deleteById(id);
    }

}