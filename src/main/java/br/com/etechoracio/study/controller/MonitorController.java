package br.com.etechoracio.study.controller;

import br.com.etechoracio.study.entity.Monitor;
import br.com.etechoracio.study.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Monitores")
public class MonitorController {
    @Autowired
    private MonitorService service;

    @GetMapping
    public List<Monitor> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Monitor buscarPorId(@PathVariable("id") Long id){
        return service.buscarPorId(id);
    }
    @PostMapping
    public Monitor cadastrar(@RequestBody Monitor monitor){
        return service.cadastrar(monitor);
    }
    @PutMapping("/{id}")
    public Monitor alterar(@RequestBody Monitor monitor,
                           @PathVariable("id") Long id){
        if(id == monitor.getId())
            return service.alterar(monitor);
        else
            return null;
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        service.deletar(id);
    }
}
