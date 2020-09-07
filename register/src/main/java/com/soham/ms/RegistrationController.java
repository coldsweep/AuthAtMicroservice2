package com.soham.ms;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soham.ms.model.Users;
import com.soham.ms.model.UsersRepo;

@RestController
public class RegistrationController 
{
	@Autowired
	private UsersRepo repo;
	
	@RequestMapping("/authuser/{userid}/{password}")
	public boolean home(@PathVariable("userid") int userid, @PathVariable("password") String password, Model model)
	{
		Users id = null;
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
			//model.addAttribute("userid", userid);
			//return "home";
			return true;
		}
		//model.addAttribute("error", "User not found");
		//return "login";
		return false;
	}
	
	@RequestMapping("/register-user/{userid}/{username}/{password}")
	public String register(@PathVariable("userid") int userid, @PathVariable("username") String username, @PathVariable("password") String password )
	{
		Users u=new Users();
		u.setId(userid);
		u.setName(username);
		u.setPassword(password);
		repo.save(u);
		return "Successfully Registered";
	}

}
