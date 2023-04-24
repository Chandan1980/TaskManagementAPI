package nz.co.solnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nz.co.solnet.dto.TaskDto;
import nz.co.solnet.dto.TaskResponseDto;
import nz.co.solnet.exception.dto.TaskNotFoundException;
import nz.co.solnet.service.TaskService;

@RestController
@RequestMapping(value = "/v1/task-management")
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TaskResponseDto> getAllTasks() {
		List<TaskResponseDto> tasks = taskService.getAll();
		if (tasks.size() == 0 || tasks == null)
			throw new TaskNotFoundException();

		return tasks;
	}

	@GetMapping(value = "/{id}/task", produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskResponseDto getTask(@PathVariable("id") long id) {

		TaskResponseDto taskDto = taskService.get(id);
		if (taskDto == null)
			throw new TaskNotFoundException();

		return taskDto;
	}

	@GetMapping("/all/task-due")
	public List<TaskResponseDto> getTask() {
		List<TaskResponseDto> tasks = taskService.getAllDue();
		if (tasks.size() == 0 || tasks == null)
			throw new TaskNotFoundException();

		return tasks;
	}

	@PostMapping("/task")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody TaskDto taskDto) {
		taskService.create(taskDto);
	}

	@PutMapping("/{id}/task")
	public void modify(@PathVariable long id, @RequestBody TaskDto taskDto) {
		taskService.modify(id, taskDto);
	}

	@DeleteMapping("/{id}/task")
	public void delete(@PathVariable long id) {
		taskService.delete(id);
	}

}
