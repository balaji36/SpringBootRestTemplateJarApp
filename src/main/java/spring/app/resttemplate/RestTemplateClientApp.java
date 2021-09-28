

package spring.app.resttemplate;



import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;



import spring.app.model.Task;

import spring.app.repository.TaskRepository;

public class RestTemplateClientApp {

	public static void main(String[] args) {
		
		//update(3);
		//deleteId(12);
		//getId(3);
	getAll();
		//create();
	}
	static void create()
	{
	RestTemplate restTemplate = new RestTemplate();
	final String url = "http://localhost:5050/api/createmployee";
	Task user = new Task();
	user.setId(10);
	user.setName("balaji");
	user.setAddrs("hyd");
	user.setFinished("false");
	Date date=new Date();
	user.setDate(date);
	Task addedUser = restTemplate.postForObject(url, user, Task.class);
	System.out.println("Task Inserted is : name: " + addedUser.getName()+" "+"id is:"+addedUser.getId());
	}
	
	static void getAll()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:5050/api/employees";
		String result =  restTemplate.getForObject(url, String.class);
		System.out.println("getAll data is"+result);
	}
	
	static void getId(@PathVariable Integer id)
	{
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:5050/api/employees/"+id;
		Task user = restTemplate.getForObject(url, Task.class);
		System.out.println("Single Record details : nameis: "+user.getName() + " " + "finished: "+user.getFinished() + " " +"id: "+ user.getId());
		
	}
	
	static void update(@PathVariable Integer id)
	{
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:5050/api/updatemployee/"+id;
		Task user = new Task();
		user.setId(2);
		user.setName("madhan");
		user.setAddrs("chennai");
		user.setFinished("true");
		restTemplate.put(url, user);
        System.out.println("update the record of id:"+id);
	}
	static void deleteId(@PathVariable Integer id)
	{
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:5050/api/deletemployee/"+id;
		restTemplate.delete(url);
		System.out.println("Deleted user details : " + id);
	}
	
	
	
		
		
	

}
