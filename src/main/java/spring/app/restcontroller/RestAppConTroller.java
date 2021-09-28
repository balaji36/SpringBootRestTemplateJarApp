package spring.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.app.service.TaskService;

@RestController
@RequestMapping(value= "/rest")
public class RestAppConTroller {
	@Autowired
	private TaskService taskService;
	@GetMapping("/")
	public String getmessage()
	{
		return "springboot app";
	}
	@GetMapping("/taskAllData")
	public String findAll()
	{
		return taskService.findAll().toString();
	}
	@GetMapping("/getTaskId")
	public String findOne(@RequestParam Integer id)
	{
		return taskService.findTask(id).toString();
	}
	@GetMapping("/getSingleTask/{id}")
	public String getOne(@PathVariable Integer id)
	{
		return taskService.findTask(id).toString();
	}
	@GetMapping("/insertTask/{name}/{addrs}")
	public String insert(@PathVariable String name,@PathVariable String addrs)
	{
		taskService.inserting(name, addrs);
		return "insert a record";
	}
	@GetMapping("/deleteTask/{id}")
	public String insert(@PathVariable Integer id)
	{
		taskService.deleting(id);
		return "delete a record based on "+id;
	}
	@GetMapping("/updateTask/{name}/{addrs}/{finish}/{id}")
	public String update(@PathVariable String name,@PathVariable String addrs,@PathVariable String finish,@PathVariable Integer id)
	{
		taskService.update(name, addrs,finish,id);
		return "record is updated based on "+ id;
	}

}
