import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.hamcrest.Matchers.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class TaskIntegrationTest {
    @Autowired
    private val mockMvc: MockMvc? = null
    @Test
    @kotlin.Throws(Exception::class)
    fun testCreateReadUpdateDeleteTask() {
         Create Task
        val newTaskJson = "{\"title\":\"Test Task\",\"description\":\"Description of Test Task\",\"completed\":false}"
        val result: MvcResult = mockMvc.perform(
            post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newTaskJson)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.title").value("Test Task"))
            .andExpect(jsonPath("$.description").value("Description of Test Task"))
            .andExpect(jsonPath("$.completed").value(false))
            .andReturn()
        val response: String = result.getResponse().getContentAsString()
        val createdTaskId: Long = JsonPath.parse(response).read("$.id", Long::class.java)

         Read Task
        mockMvc.perform(get("/tasks/$createdTaskId"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(createdTaskId))
            .andExpect(jsonPath("$.title").value("Test Task"))
            .andExpect(jsonPath("$.description").value("Description of Test Task"))
            .andExpect(jsonPath("$.completed").value(false))

         Update Task
        val updatedTaskJson = "{\"title\":\"Updated Task\",\"description\":\"Updated Description\",\"completed\":true}"
        mockMvc.perform(
            put("/tasks/$createdTaskId")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedTaskJson)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(createdTaskId))
            .andExpect(jsonPath("$.title").value("Updated Task"))
            .andExpect(jsonPath("$.description").value("Updated Description"))
            .andExpect(jsonPath("$.completed").value(true))

         Delete Task
        mockMvc.perform(delete("/tasks/$createdTaskId"))
            .andExpect(status().isNoContent())

         Verify Task is Deleted
        mockMvc.perform(get("/tasks/$createdTaskId"))
            .andExpect(status().isNotFound())
    }
}