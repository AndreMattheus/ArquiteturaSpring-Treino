package com.github.andremattheus.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository; //Injetando dependência

    public TodoValidator(TodoRepository repository) {
        this.repository = repository; //Construindo a dependência para uso
    }

    public void validar(TodoEntity todo){
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um ToDO com esta descrição!");
        }

    }

    private boolean existeTodoComDescricao(String descricao){
        return repository.existsByDescricao(descricao);
    }
}
