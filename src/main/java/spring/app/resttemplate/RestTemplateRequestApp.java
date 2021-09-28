package spring.app.resttemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import spring.app.model.Task;



@RestController
public class RestTemplateRequestApp 
{
	@GetMapping("/getAllEmployees")//execuited
	public  String getEmployees()
	{
	    final String uri = "http://localhost:5050/api/employees";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println("data is"+result); 
	    return result;    
	}
	
	@GetMapping("/getSingleEmployeee/{id}")//working
	public String getSingleRecord(@PathVariable(value="id") int id) 
	{
		
		 final String uri = "http://localhost:5050/api/employees/"+id;
		   RestTemplate restTemplate = new RestTemplate();
		   Task result = restTemplate.getForObject(uri, Task.class, id);
		    System.out.println("data is"+result);
		    return " result of data is: "+id;   
		}
	
	
	@DeleteMapping("/deleteEmployee/{id}")// working
	public String deleteRecord(@PathVariable(value="id") int id) 
	{
		//ModelAndView model = new ModelAndView();
		 final String uri = "http://localhost:5050/api/deletemployee/"+id;
	       
		   RestTemplate restTemplate = new RestTemplate();
		   Map<String, Integer> params = new HashMap<String, Integer>();
		    params.put("id",id);
		    restTemplate.delete (uri,params);//,  id);
		   // System.out.println("data is"+result);
		   // model.setViewName("resultDelete"); 
		    return id+" record is deleted";   
	}
	
	
			
	@GetMapping("/insertEmployee/{id}/{name}/{addrs}/{finished}/{date}")// working
	public String insertRecord(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("addrs") String addrs,@PathVariable("finished") String finished,@PathVariable("date") String date) throws Exception
	{
		
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:5050/api/createmployee";
		Task user = new Task();
		user.setId(id);
		user.setName(name);
		user.setAddrs(addrs);
		user.setFinished(finished);
		 String sDate1=date;  
		    Date date1=new SimpleDateFormat("YYYY-MM-DD").parse(sDate1);  
		
		user.setDate(date1);
		Task addedUser = restTemplate.postForObject(url, user, Task.class);
		 System.out.println("result is insert a record...id "+name+" "+"addrs "+addrs+" "+"finished "+finished);
		 
		 final String url1 = "http://localhost:5050/api/employees";
			String result =  restTemplate.getForObject(url1, String.class);
	    return result;  

	}
	
	
	@GetMapping("/updateEmployee/{id}/{name}/{addrs}/{finished}")// working
	public String  updateRecord(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("addrs") String addrs,@PathVariable("finished") String finished) 
	{
		//ModelAndView model = new ModelAndView();
		final String uri = "http://localhost:5050/api/updatemployee/"+id;
	
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:5050/api/updatemployee/"+id;
		Task user = new Task();
		user.setId(id);
		user.setName(name);
		user.setAddrs(addrs);
		user.setFinished(finished);
		Date date=new Date();
		user.setDate(date);
		restTemplate.put(url, user);
        System.out.println("update the record of id:"+id);
	    
		 //   model.setViewName("resultUpdate"); 
		    return "update the record is: "+id;  
	}
	
	
	

}
