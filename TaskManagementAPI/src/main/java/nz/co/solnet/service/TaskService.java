package nz.co.solnet.service;

import java.util.List;

import nz.co.solnet.dto.TaskDto;
import nz.co.solnet.dto.TaskResponseDto;

public interface TaskService {

	List<TaskResponseDto> getAll();

	TaskResponseDto get(long id);

	List<TaskResponseDto> getAllDue();

	void create(TaskDto taskDto);

	void modify(long id, TaskDto taskDto);

	void delete(long id);

}
