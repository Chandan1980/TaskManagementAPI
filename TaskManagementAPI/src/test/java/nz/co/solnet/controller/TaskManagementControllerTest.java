/*
 * package nz.co.solnet.controller;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.RequestBuilder; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc;
 * 
 * import com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * import nz.co.solnet.dto.TaskDto; import nz.co.solnet.dto.TaskResponseDto;
 * import nz.co.solnet.service.TaskService;
 * 
 * @SpringBootTest(classes = TaskController.class)
 * 
 * @AutoConfigureMockMvc(addFilters = false)
 * 
 * @EnableWebMvc public class TaskManagementControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private TaskService taskService;
 * 
 * 
 * @Test public void testCreateTask() throws Exception { TaskDto taskDto = new
 * TaskDto(); taskDto.setTitle("Test"); RequestBuilder requestBuilder =
 * MockMvcRequestBuilders.post("/v1/task-management/task")
 * .accept(MediaType.APPLICATION_JSON).content(getObjectAsAString(taskDto))
 * .contentType(MediaType.APPLICATION_JSON); MvcResult result =
 * mockMvc.perform(requestBuilder).andReturn();
 * assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus()); }
 * 
 * @Test public void testUpdateTask() throws Exception { TaskDto taskDto = new
 * TaskDto(); taskDto.setTitle("Test"); RequestBuilder requestBuilder =
 * MockMvcRequestBuilders.put("/v1/task-management/1/task")
 * .accept(MediaType.APPLICATION_JSON).content(getObjectAsAString(taskDto))
 * .contentType(MediaType.APPLICATION_JSON); MvcResult result =
 * mockMvc.perform(requestBuilder).andReturn();
 * assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus()); }
 * 
 * @Test public void testGetAllTasks() throws Exception { List<TaskResponseDto>
 * taskDtoList = new ArrayList<>(); TaskResponseDto taskDto = new
 * TaskResponseDto(); taskDto.setTitle("Test"); taskDtoList.add(taskDto);
 * Mockito.when(taskService.getAll()).thenReturn(taskDtoList); RequestBuilder
 * requestBuilder =
 * MockMvcRequestBuilders.get("/v1/task-management/all").accept(MediaType.
 * APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON); MvcResult result
 * = mockMvc.perform(requestBuilder).andReturn();
 * assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus()); }
 * 
 * @Test public void testGetTask() throws Exception { TaskResponseDto taskDto =
 * new TaskResponseDto(); taskDto.setTitle("Test");
 * Mockito.when(taskService.get(1l)).thenReturn(taskDto); RequestBuilder
 * requestBuilder =
 * MockMvcRequestBuilders.get("/v1/task-management/1/task").accept(MediaType.
 * APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON); MvcResult result
 * = mockMvc.perform(requestBuilder).andReturn();
 * assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus()); }
 * 
 * @Test public void testDeleteTask() throws Exception {
 * 
 * RequestBuilder requestBuilder =
 * MockMvcRequestBuilders.delete("/v1/task-management/1/task").accept(MediaType.
 * APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON); MvcResult result
 * = mockMvc.perform(requestBuilder).andReturn();
 * assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus()); }
 * 
 * private String getObjectAsAString(Object obj) throws JsonProcessingException
 * { ObjectMapper mapper = new ObjectMapper(); return
 * mapper.writeValueAsString(obj); }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */