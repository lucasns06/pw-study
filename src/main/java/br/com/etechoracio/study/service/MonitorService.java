package br.com.etechoracio.study.service;
import br.com.etechoracio.study.entity.Monitor;
import br.com.etechoracio.study.repository.DisciplinaRepository;
import br.com.etechoracio.study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {
    @Autowired
    private MonitorRepository repository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Monitor> listar(){
        return repository.findAll();
    }
    public Monitor buscarPorId(Long id){
        var existe =  repository.findById(id);
        if(existe.isPresent())
            return existe.get();
        return null;
    }

    public Monitor cadastrar(Monitor monitor){
        if(monitor.getDisciplina() != null){
            return repository.save(monitor);
        }
        else{
            System.out.println("Disciplina não encontrada, cadastrar o monitor negado!");
            return null;
        }
    }

    public Monitor alterar(Monitor monitor){
        var existe = buscarPorId(monitor.getId());
        if(existe != null){
            if(monitor.getDisciplina() != null){
                return repository.save(monitor);
            }
            else{
                System.out.println("Disciplina não encontrada, impossivel alterar o monitor");
                return null;
            }
        }
        else{
            System.out.println("Monitor não encontrado");
            return null;
        }
    }

    public void deletar(Long id){
        var existe = buscarPorId(id);
        if(existe != null)
            repository.deleteById(id);
        else{
            System.out.println("Monitor não encontrado, impossivel deletar!");
        }
    }
}
