package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.dto.VenueDTO;
import com.cg.ems.service.VenueService;
@RestController
@RequestMapping("/api/venue")
public class VenueController {
	@Autowired
	public VenueService venueService;
	
	//http://localhost:8091/api
	
	@PostMapping("/addVenue")
	public ResponseEntity<VenueDTO> addVenue(@RequestBody VenueDTO venueDTO){
		VenueDTO venue=venueService.addVenue(venueDTO);
		return ResponseEntity.ok(venue);
		
		
	}
 
	@GetMapping("/fetchVenueById/{venueId}")
	   public ResponseEntity<VenueDTO> getVenueByVenueId(@PathVariable int venueId){
		VenueDTO venueDTO = venueService.getById(venueId);
		return new ResponseEntity<VenueDTO>(venueDTO, HttpStatus.FOUND);
		
	}
	
	@PutMapping("/updateVenue/{venueId}")
	public ResponseEntity<VenueDTO> updateVenue(@RequestBody VenueDTO venueDTO) {
		
		return new ResponseEntity<VenueDTO>(venueService.updateVenue(venueDTO), HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/deleteVenue/{venueId}")
	public ResponseEntity<Boolean> deleteVenueByVenueId(@PathVariable int venueId){
		VenueDTO venueDTO = venueService.getById(venueId);
		if(venueDTO!=null)
			venueService.deleteVenue(venueDTO);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		//throw new VenueNotAvailableException();
	}
	

	@GetMapping("/fetchAllVenue")
	public ResponseEntity<List<VenueDTO>> getAllVenue() {
		List<VenueDTO> list = venueService.findAll();
		return ResponseEntity.ok(list);
	}
}
