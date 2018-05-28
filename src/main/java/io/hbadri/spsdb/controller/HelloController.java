package io.hbadri.spsdb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author badri.houssem@gmail.com
 *
 */
@RestController()
public class HelloController {

	@GetMapping()
	public String hello() {
		return "Welcome to the public page";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')") //Method level authorization
	@GetMapping("/secure")
	public String securedHello() {
		return "Welcome to the secured admin page";
	}
}
