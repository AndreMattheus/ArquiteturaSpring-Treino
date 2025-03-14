package com.github.andremattheus.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    // Injetando dependências
    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    // Construindo as dependências para ele saber que e para injetar
    public TodoService(TodoRepository repository,
                       TodoValidator validator,
                       MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído" : "Não concluído";
        mailSender.sendMail("ToDO " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
}
