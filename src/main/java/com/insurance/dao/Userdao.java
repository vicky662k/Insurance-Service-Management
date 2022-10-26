package com.insurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.insurance.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Userdao {
	@Autowired
	JdbcTemplate t;

	public List<User> getuserfromdb() {

		List<User> ulist= new ArrayList<>();
		t.query("select * from test.user", new ResultSetExtractor <List<User>>() {
			public List<User> extractData(ResultSet rs) throws SQLException,DataAccessException{

				while(rs.next()) {
					User u=new User();
					u.setUserid(rs.getInt("userid"));
					u.setFirstname(rs.getString("firstname"));
					u.setEmail(rs.getString("email"));
					u.setStreet(rs.getString("street"));

					ulist.add(u);
				}
				return ulist;
			}
		});

		return ulist;

	}
	
	public List<User> insertnewusr(User u) {
		
		String sql="insert into test.user(userid,firstname,email,street)values("+u.getUserid()+",'"+u.getFirstname()+"','"+u.getEmail()+"','"+u.getStreet()+"');";
		
		t.execute(sql);
		
		List<User> userlist=getuserfromdb();
		return userlist;
	}
	
	public List<User> deluser(User u){
		String sql="delete from test.user where userid="+u.getUserid()+";";
		t.execute(sql);
		
		List<User>dlist=getuserfromdb();
		return dlist;
	}
	
	public List<User> putuser(User u){
		String sql="update test.user set firstname='"+u.getFirstname()+"' where userid="+u.getUserid()+";";
		t.execute(sql);
		
		List<User>plist=getuserfromdb();
		return plist;
	}
}
