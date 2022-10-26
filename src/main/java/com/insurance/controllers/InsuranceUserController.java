package com.insurance.controllers;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.constants.InsuranceConstants;
import com.insurance.entites.Users;
import com.insurance.model.Agent;
import com.insurance.model.User;
import com.insurance.service.InsuranceAgentService;

/**
 * 
 * @author eyjfsaw29
 * @since 11/09/2022
 * @version 1.0
 *
 */
@RestController
public class InsuranceUserController {

	@Autowired
	private InsuranceAgentService obj;

	/**
	 * @RequestMapping(value="/getdata",method=RequestMethod.GET)
	 * public String gethello(@RequestParam(name="agent" ,required =true) String a) {
	 * return "hello "+a;
	 */
	@RequestMapping(value=InsuranceConstants.GET_AGENT_DATA,method=RequestMethod.GET)
	public String gethello(@PathVariable(InsuranceConstants.PATH) String a) {
		return InsuranceConstants.MSG +a;
	}

	@RequestMapping(value=InsuranceConstants.POST_AGENT_DATA,method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public Agent getagentdetais(@RequestBody Agent a) {

		System.out.println(a.getId());
		System.out.println(a.getVendor());
		System.out.println(a.getContact());
		System.out.println(a.getBranch());
		return a;

	}

	@RequestMapping(value=InsuranceConstants.POST_BY_ID,method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public Agent getagentonid(@RequestBody Agent b) {

		if(Objects.nonNull(b))
			System.out.println("invalid data");
		if(b.getId()==0)
			System.out.println("id is invalid");

		Agent agentdetail=obj.getAllagents(b.getId());

		return agentdetail;
	}

	@RequestMapping(value=InsuranceConstants.PUT_BY_ID,method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Agent> putagent(@RequestBody Agent c) {
		if(c.getId()==0)
			throw new IllegalArgumentException("Id is invalid");
		if(c.getVendor()==""||c.getBranch()==""||c.getBranch()=="")
			throw new IllegalArgumentException("Data invalid");

		List<Agent>alist = obj.insertagent(c);
		return alist;

	}
	
	@RequestMapping(value="/addusr",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> adduser(@RequestBody User u) {
		
		List<User>uslist=obj.insertuser(u);
		return uslist;
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User>delete(@RequestBody User u){
		List<User>delist=obj.deleteuser(u);
		return delist;
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User>put(@RequestBody User u){
		List<User>pulist=obj.putuser(u);
		return pulist;
		
	}
	
	@RequestMapping(value="/getuserdb",method=RequestMethod.GET)
	public List<User> getusers() {
		List<User> userlist=obj.getusrsfromdb();
		return userlist;
	
	}
	
	@RequestMapping(value="/getallusers",method=RequestMethod.GET)
	public List<Users> getllusers() {
		List<Users> usrlist=obj.getallusers();
		return usrlist;
	
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users> saveuser(@RequestBody Users u) {
		
		List<Users>uslist=obj.savenewuser(u);
		return uslist;
		
	}
}
