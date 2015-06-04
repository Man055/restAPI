package restapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import restapi.dao.User;
import restapi.dao.UserDAO;
import restapi.model.EncodeJSON;
import restapi.model.EncodeXML;

@RestController
@RequestMapping("/json")
public class JsonRes {

	@RequestMapping(value="/{userID}",method=RequestMethod.GET)
	public @ResponseBody EncodeXML fetch(@PathVariable int userID,HttpServletRequest request){
		User user = new User();
		user.setUserID(userID);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernateconf.xml");
		UserDAO userDAO = context.getBean(UserDAO.class);
		userDAO.getRecords(user);
		System.out.println("-----");
		System.out.println(user.getEmail());
		//if(user.getEmail()==null)
			//return new EncodeJSON("notice","No Records Found");
		//return new EncodeJSON("success",user);
		return new EncodeXML(user);
		
	}
	
	@RequestMapping(value="/{userID}",method=RequestMethod.DELETE)
	public @ResponseBody EncodeJSON delete(@PathVariable int userID){
		User user = new User();
		return new EncodeJSON("notice","No User for deleting");
		
	}
}
