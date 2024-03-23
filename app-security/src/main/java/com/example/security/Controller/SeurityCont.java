package com.example.security.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SeurityCont {
	  
	
   Logger logger=LoggerFactory.getLogger(SeurityCont.class);
	
    @GetMapping("/home/call")
	public String call() {
    	logger.trace("getting into call method at trace level");
    	logger.info("gettin into call method at info level");
    	logger.warn("getting into call method at warn level");
		return "hello welcome to spring security";
	}
    @GetMapping("/user/greet")
    public String user() {
		return "just greeting you";
    	
    }
    
    
    @GetMapping("/admin/length")
    public String length() {
    	String s="bhaskar kumar";
    	try {
    		logger.debug("getting into try block at debug level");
    		logger.warn("getting into try block at warn");
    		logger.trace("getting into try block at trace level");
    		return "lendth "+s.length();
    	}
    	catch (Exception e) {
			logger.error("getting error in cath block");
    		return "the string is null";
		}
    	
    }
}
