package com.alves.school.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.alves.school.resource.StudentResource;

@ApplicationPath("/school")
public class SchoolApllicationConfig extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public SchoolApllicationConfig() {
	        singletons.add(new StudentResource());
	    }

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
