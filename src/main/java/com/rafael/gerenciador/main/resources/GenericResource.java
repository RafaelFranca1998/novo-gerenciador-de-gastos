package com.rafael.gerenciador.main.resources;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;

import com.rafael.gerenciador.main.utils.Util;


public class GenericResource {

	protected PageRequest getPagination(Integer pageNumber, Integer pageSize, String sortName, String sortOrder){	
		return Util.getPagination(pageNumber, pageSize, sortName, sortOrder);
	}
	
	protected PageRequest getPagination(Integer pageNumber, Integer pageSize){	
	    return Util.getPagination(pageNumber, pageSize);
	}
	
//	protected Person getUserLogged(HttpSession session) {
//		Person userLogin = Util.getUserLogin(session);
//		if (userLogin == null) {
//			throw new AuthorizationException("User is not logged in");
//		}
//			
//		return userLogin;
//	}

}
