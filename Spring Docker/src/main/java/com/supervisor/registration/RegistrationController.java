package com.supervisor.registration;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class RegistrationController {

	@GetMapping("/supervisors")
	List<String> getSupervisors() {
		return SupervisorList.parseSupers();
	}
	@PostMapping("/submit")
	void registerSupervisor(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, 
			@RequestParam(value="email", required = false) String email, @RequestParam(value="phoneNumber", required = false) String phoneNumber, 
			@RequestParam(value="supervisor") String supervisor) {
		Registration r = new Registration(firstName, lastName, email, phoneNumber, supervisor);
		r.submit();
		return;
	}
}
