//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//import java.util.List
//import java.util.Optional
//
//@RestController
//@RequestMapping("/tasks")
//class TaskController {
//    @Autowired
//    private val taskRepository: TaskRepository? = null
//
//    @get:GetMapping
//    val allTasks: List<Any>
//        get() = taskRepository.findAll()
//
//    @GetMapping("/{id}")
//    fun getTaskById(@PathVariable id: Long?): ResponseEntity<Task> {
//        val task: Optional<Task> = taskRepository.findById(id)
//        return if (task.isPresent()) {
//            ResponseEntity.ok(task.get())
//        } else {
//            ResponseEntity.notFound().build()
//        }
//    }
//
//    @PostMapping
//    fun createTask(@RequestBody task: Task?): Task {
//        return taskRepository.save(task)
//    }
//
//    @PutMapping("/{id}")
//    fun updateTask(@PathVariable id: Long?, @RequestBody taskDetails: Task): ResponseEntity<Task> {
//        val task: Optional<Task> = taskRepository.findById(id)
//        return if (task.isPresent()) {
//            val updatedTask: Task = task.get()
//            updatedTask.setTitle(taskDetails.getTitle())
//            updatedTask.setDescription(taskDetails.getDescription())
//            updatedTask.setCompleted(taskDetails.isCompleted())
//            taskRepository.save(updatedTask)
//            ResponseEntity.ok(updatedTask)
//        } else {
//            ResponseEntity.notFound().build()
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteTask(@PathVariable id: Long?): ResponseEntity<Void> {
//        val task: Optional<Task> = taskRepository.findById(id)
//        return if (task.isPresent()) {
//            taskRepository.delete(task.get())
//            ResponseEntity.noContent().build()
//        } else {
//            ResponseEntity.notFound().build()
//        }
//    }
//}