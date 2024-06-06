/*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class TaskPersistenceTest {
    @Autowired
    private val mockMvc: MockMvc? = null
    @Test
    @kotlin.Throws(Exception::class)
    fun testDataPersistenceBetweenRestarts() {
        // Create Task
        val newTaskJson =
            "{\"title\":\"Persistent Task\",\"description\":\"Task to test persistence\",\"completed\":false}"
        val result: MvcResult = mockMvc.perform(
            post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newTaskJson)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.title").value("Persistent Task"))
            .andExpect(jsonPath("$.description").value("Task to test persistence"))
            .andExpect(jsonPath("$.completed").value(false))
            .andReturn()
        val response: String = result.getResponse().getContentAsString()
        val createdTaskId: Long = JsonPath.parse(response).read("$.id", Long::class.java)

        // Simulate Application Restart (in reality, stop and start the application manually or via a script)

        // Read Task after "restart"
        mockMvc.perform(get("/tasks/$createdTaskId"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(createdTaskId))
            .andExpect(jsonPath("$.title").value("Persistent Task"))
            .andExpect(jsonPath("$.description").value("Task to test persistence"))
            .andExpect(jsonPath("$.completed").value(false))
    }
}*/
