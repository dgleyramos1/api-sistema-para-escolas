package com.escolar.Controller;

import com.escolar.Entity.Aluno;
import com.escolar.Repository.AlunoRepo;
import com.escolar.Repository.EnderecoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerAluno {

    private final AlunoRepo repository;

    public ControllerAluno(AlunoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/aluno")
    public ResponseEntity<?> findAllAlunos(){
        try{
            List<Aluno> allAlunos = repository.findAll();
            if (allAlunos.isEmpty())
                System.out.println("Vazio");
            return new ResponseEntity<>(allAlunos, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<Aluno> findAlunoById(@PathVariable Long id){
        Optional<Aluno> alunoOptional = repository.findById(id);
        if (alunoOptional.isPresent()){
            Aluno alunoUnid = alunoOptional.get();
            return new ResponseEntity<>(alunoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/aluno")
    public Aluno newAluno(@RequestBody Aluno novoAluno){
        return repository.save(novoAluno);
    }
}
