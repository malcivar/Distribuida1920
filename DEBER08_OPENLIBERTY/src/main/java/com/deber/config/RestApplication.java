package com.deber.config;





import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationScoped
@ApplicationPath(value = "/")
public class RestApplication extends Application {

	
	
}
