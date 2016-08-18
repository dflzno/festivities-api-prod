package com.github.dlozanoc.festapivity.application.festivities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.dlozanoc.festapivity.application.domain.Festivity;
import com.github.dlozanoc.festapivity.application.integration.FestivityListResource;
import com.github.dlozanoc.festapivity.application.integration.FestivityResource;
import com.github.dlozanoc.festapivity.application.integration.mappers.FestivityResourceMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FestivityController {

	@Autowired
	private FestivityService festivityService;

	@Autowired
	private FestivityResourceMapper festivityEntityMapper;

	@RequestMapping(value = "/api/festivity", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<FestivityListResource> getAll() {
		Optional<List<Festivity>> festivities = null;
		
		try {
			festivities = festivityService.getAll();
			if(festivities.isPresent()) {
				if(!festivities.get().isEmpty()) {
					log.debug("Festivities found {}", festivities.get().stream().map(Object::toString).collect(Collectors.joining()));
					List<FestivityResource> resources = new ArrayList<>(festivities.get().size());
					
					FestivityResource resource = null;
					for(Festivity f : festivities.get()) {
						resource = festivityEntityMapper.apply(f);
						resource.add(linkTo(methodOn(FestivityController.class).getById(resource.getFestId())).withSelfRel());
						resources.add(resource);
					}
					
					FestivityListResource responseContent = new FestivityListResource(resources);
					responseContent.add(linkTo(methodOn(FestivityController.class).getAll()).withSelfRel());
					return new ResponseEntity<FestivityListResource>(responseContent, HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/api/festivity/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<FestivityResource> getById(@PathVariable Long id) {
		
		try {
			Optional<Festivity> festivity = festivityService.getById(id);
			if(festivity.isPresent()) {
				FestivityResource resource = festivityEntityMapper.apply(festivity.get());
				resource.add(linkTo(methodOn(FestivityController.class).getById(resource.getFestId())).withSelfRel());
				return new ResponseEntity<FestivityResource>(resource, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
}
