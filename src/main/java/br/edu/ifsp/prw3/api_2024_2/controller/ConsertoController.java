package br.edu.ifsp.prw3.api_2024_2.controller;

import br.edu.ifsp.prw3.api_2024_2.conserto.Conserto;
import br.edu.ifsp.prw3.api_2024_2.conserto.ConsertoRepository;
import br.edu.ifsp.prw3.api_2024_2.conserto.DadosConserto;
import br.edu.ifsp.prw3.api_2024_2.conserto.DadosListagemConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados) {
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao);
    }


    @GetMapping("algunsdados")
    public List<DadosListagemConserto> listarAlgunsDados() {
        return repository.findAll().stream()
                .map(DadosListagemConserto::new)
                .toList();
    }

}
