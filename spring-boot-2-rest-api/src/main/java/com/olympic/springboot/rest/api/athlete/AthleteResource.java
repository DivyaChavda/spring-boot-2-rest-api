package com.olympic.springboot.rest.api.athlete;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AthleteResource {
	
	@Autowired
	private AthleteRepository athleteRepository; 
	
	@GetMapping("/athletes")
	public List<Athlete> getAll(){
		return athleteRepository.findAll();
	}
	
	@DeleteMapping("/athletes/{id}")
	public void deleteAthlete (@PathVariable Long id) {
		athleteRepository.deleteById(id);
	}
	
	@PostMapping("/athletes")
	public ResponseEntity<Object> addAthlete(@RequestBody Athlete athlete){
		
		Athlete savedAthlete = athleteRepository.save(athlete);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAthlete.getID()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/athletes/{id}")
	public ResponseEntity<Object> upddateAthlete(@RequestBody Athlete athlete, @PathVariable long id){
		
		Optional <Athlete> optionalAthlete = athleteRepository.findById(id);
		
		if(!optionalAthlete.isPresent())
			return ResponseEntity.notFound().build();
		
		athlete.setID(id);
		
		athleteRepository.save(athlete);
		
		return ResponseEntity.noContent().build(); 
	}
}
