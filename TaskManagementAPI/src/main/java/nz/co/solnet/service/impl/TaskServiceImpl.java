package nz.co.solnet.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nz.co.solnet.dto.TaskDto;
import nz.co.solnet.dto.TaskResponseDto;
import nz.co.solnet.entity.Task;
import nz.co.solnet.exception.dto.SevereException;
import nz.co.solnet.reposiroty.TaskRepository;
import nz.co.solnet.service.TaskService;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TaskResponseDto> getAll() {
		List<Task> tasks = taskRepository.findAll();
		return tasks.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public TaskResponseDto get(long id) {
		return convertToDto(getTask(id));
	}

	@Override
	public List<TaskResponseDto> getAllDue() {
		return taskRepository.findAllDueTasks().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public void create(TaskDto taskDto) {
		try {
			taskRepository.save(convertToEntity(taskDto));
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SevereException();
		}
		log.info("Task Created");

	}

	@Override
	public void modify(long id, TaskDto taskDto) {
		Task task = getTask(id);
		task.setCreation_date(taskDto.getCreation_date());
		task.setDue_date(taskDto.getDue_date());
		task.setTitle(taskDto.getTitle());
		task.setStatus(taskDto.getStatus());
		task.setDescription(taskDto.getDescription());

		try {
			taskRepository.save(task);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SevereException();
		}
		log.info("Task Modified");

	}

	@Override
	public void delete(long id) {
		try {
			taskRepository.deleteById((int) id);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SevereException();
		}

	}

	private TaskResponseDto convertToDto(Task task) {
		return modelMapper.map(task, TaskResponseDto.class);
	}

	private Task convertToEntity(TaskDto taskDto) {
		return modelMapper.map(taskDto, Task.class);
	}

	private Task getTask(long id) {

		Optional<Task> taskOptional = taskRepository.findById((int) id);
		if (taskOptional.isPresent()) {
			return taskOptional.get();
		}
		return null;

	}

}
