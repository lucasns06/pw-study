package br.com.etechoracio.study.service;

import br.com.etechoracio.study.entity.Disciplina;
import br.com.etechoracio.study.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.CdiRepositoryExtensionSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> listar(){
        return repository.findAll();
    }

    public Disciplina buscarPorId(Long id){
        var existe =  repository.findById(id);
        if(existe.isPresent())
            return existe.get();
        return null;
    }
    //cadastrar disciplina

    public Disciplina cadastrar(Disciplina disciplina){
        return repository.save(disciplina);
    }
    //Alterar
    public Disciplina alterar(Disciplina disciplina){
        var existe =  buscarPorId(disciplina.getId());
        if(existe != null)
            return  repository.save(disciplina);
        else {
            System.out.println("Disciplina não encontrada");
            return null;
        }
    }

    public void deletar(Long id){
        var existe =  buscarPorId(id);
        if(existe != null)
              repository.deleteById(id);
        else {
            System.out.println("Disciplina não encontrada, impossivel deletar");
        }
    }
}
