package com.soham.ms;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.soham.ms.model.Users;
import com.soham.ms.model.UsersRepo;

@Controller
public class LoginController 
{
	@Autowired
	private UsersRepo repo;
	
	RestTemplate rest=new RestTemplate();
	
	@RequestMapping("/")
	public String login()
	{
		return "login";
	}
	@RequestMapping("/login")
	public String home(@RequestParam("userid") int userid, @RequestParam("password") String password, Model model)
	{
		String s=rest.getForObject("http://localhost:8081/authuser/"+userid+"/"+password, String.class);
		boolean check=Boolean.parseBoolean(s);
		if(check==true)
		{
			model.addAttribute("userid", userid);
			return "home";
		}
		model.addAttribute("error", "User not found");
		return "login";
		
		/*Users id = null;
		boolean check=false;
		try 
		{
			Optional<Users> ou=repo.findById(userid);
			id=ou.get();
			
			if(id.getPassword().equals(password))
			{
				check=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("User not found");
		}
		if(check==true)
		{
			model.addAttribute("userid", userid);
			return "home";
		}
		model.addAttribute("error", "User not found");
		return "login";*/
	}
	@RequestMapping("/register")
	public String reguser()
	{
		return "register";
	}
	@RequestMapping("/reguser")
	public String registeruser(@RequestParam("userid") int userid, @RequestParam("username") String username, @RequestParam("password") String password, Model model) 
	{
		rest.getForObject("http://localhost:8081/register-user/"+userid+"/"+username+"/"+password, String.class);
		model.addAttribute("registerSuccess","Successfully registered");  
		return "login";
	}
}
