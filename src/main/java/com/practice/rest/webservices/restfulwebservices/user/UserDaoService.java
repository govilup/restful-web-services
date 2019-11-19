package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

//Later on change the annotation to @Repository since this is going to talk to DB.
@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    
    private static int userCount = 104;

    static {
	users.add(new User(101, "Govil", LocalDate.parse("14/03/1991", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	users.add(new User(102, "Preeti", LocalDate.parse("25/04/1993", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	users.add(new User(103, "Durga", LocalDate.parse("14/03/1991", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	users.add(new User(104, "Aruna", LocalDate.parse("20/01/1991", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }
    
    public List<User> findAll(){
	return users;
    }
    
    public User saveUser(User user) {
	if(user.getId() == null) {
	    user.setId(++userCount);
	}
	users.add(user);
	return user;
    }
    
    public User findUser(int id) {
	for(User user : users) {
	    if(user.getId() == id) {
		return user;
	    }
	}
	return null;
    }
    
    public User deleteById(int id) {
	//users.removeIf(x ->  x.getId() == id);
	Iterator<User> iterator = users.iterator();
	while(iterator.hasNext()) {
	    User user = iterator.next();
	    if(user.getId() == id) {
		iterator.remove();
		return user;
	    }
	}
	return null;
    }
}
