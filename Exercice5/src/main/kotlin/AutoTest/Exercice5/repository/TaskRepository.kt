import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task?, Long?>
