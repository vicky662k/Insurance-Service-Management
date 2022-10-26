package com.insurance.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.Userdao;
import com.insurance.entites.Users;
import com.insurance.model.Agent;
import com.insurance.model.User;

import com.insurance.repos.UserRepository;

@Service
public class InsuranceAgentService {
	@Autowired
	Userdao u;
	
	@Autowired
	UserRepository ur;
	
	List<Agent> alist= new ArrayList<>();
	List<Agent>Ulist=new ArrayList<>();
	
	public Agent getAllagents(int id) {

		Optional<Agent> agentoption=getagent().stream().filter(x->id==x.getId()).findFirst();
		return agentoption.get();		

	}

	private List<Agent> getagent(){

		Agent a1=new Agent(1,"hdfc","94950","SPL PBB");
		Agent a2=new Agent(2,"icici","94950","TVM");
		Agent a3=new Agent(3,"sbi","94950","KLM");

		List<Agent> alist= Arrays.asList(a1,a2,a3);
		return alist;

	}

	public List<Agent> insertagent(Agent c) {
		
		

		try {
			Ulist.add(c);
			Ulist.addAll(getagent());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return Ulist;

	}

	public List<Agent> deleteagent(int id) {
		List<Agent> al=new ArrayList<>();
		for(Agent c:alist)
		if(id==c.getId()) {
			Ulist.remove(alist.indexOf(c));
		}
		al.addAll(alist);
		return al;
	}
	
	public List<User> getusrsfromdb() {
		List<User> ulist= u.getuserfromdb();
		return ulist;
		
	}
	
	public List<User> insertuser(User user) {
		
		List<User> userlist=u.insertnewusr(user);
		return userlist;
	
	}
	
	public List<User> deleteuser(User user){
		List<User> delist =u.deluser(user);
		return delist;
	}
	
	public List<User> putuser(User user){
		List<User> pulist =u.putuser(user);
		return pulist;
	}
	
	public List<Users> getallusers(){
		List<Users> usrlist =ur.findAll();
		return usrlist;
	}
	
	public List<Users> savenewuser(Users u){
		ur.save(u);
		List<Users> usrlist=getallusers();
		return usrlist;
	}
}


