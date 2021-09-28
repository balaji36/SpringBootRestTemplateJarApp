package spring.app.resttemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import spring.app.model.Task;
import spring.app.repository.TaskRepository;

@RestController
@RequestMapping("/api")
public class RestTemplateServerApp {
	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/employees")
	public List<Task> getAllEmployees() {
		System.out.println("data is......."+(List<Task>) taskRepository.findAll());
		
		return (List<Task>) taskRepository.findAll();
	}

	@PostMapping("/createmployee")
	public Task createEmployee(@Valid @RequestBody Task employee) {
		return taskRepository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Task> getEmployeeById(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Task employee = taskRepository.findOne(employeeId);
		 new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/updatemployee/{id}")
	public ResponseEntity<Task> updateEmployee(@PathVariable(value = "id") int employeeId,
			@Valid @RequestBody Task employeeDetails) throws ResourceNotFoundException {
		Task  employee = taskRepository.findOne(employeeId);
				 new ResourceNotFoundException("Employee not found for this id :: " + employeeId);

		employee.setName(employeeDetails.getName());
		employee.setAddrs(employeeDetails.getAddrs());
		employee.setFinished(employeeDetails.getFinished());
		employee.setDate(employeeDetails.getDate());
		final Task updatedEmployee = taskRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/deletemployee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Task employee = taskRepository.findOne(employeeId);
		 new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		taskRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
