package com.bkhaled.squidws.admin.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("profiles")
public class ProfileResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProfiles(){
		return "Heyy Profiles...";
	}
	
	
}
