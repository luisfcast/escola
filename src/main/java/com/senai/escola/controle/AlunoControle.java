package com.senai.escola.controle;

import com.senai.escola.Models.Aluno;
import com.senai.escola.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping
@RestController("/alunos")
public class AlunoControle {
    private final AlunoService alunoService;


    public AlunoControle(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> buscarTodosAluno() {
        return alunoService.buscarAlunos();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.salvarNovoAluno(aluno);
    }

    @DeleteMapping
    public void excluirAluno(Long id) {
        alunoService.deletarAluno(id);
    }

    @GetMapping("/{id}")
    public Aluno buscaAlunoPorid(@PathVariable Long id) {
        return alunoService.buscarAlunoId(id);

    }
}
