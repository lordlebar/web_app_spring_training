package fr.lernejo.todo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/todo")
public class TodoListController {


    private final TodoRepository repository;

    TodoListController(TodoRepository todoRepository) {
        repository = todoRepository;
    }

    @GetMapping
    public Iterable<TodoEntity> todos(){
       // var allTodo = (List<TodoEntity>) repository.findAll();
        return repository.findAll();
    }

    @PostMapping
    public void saveTodo(@RequestBody TodoEntity todo){
        repository.save(todo);
    }


}
