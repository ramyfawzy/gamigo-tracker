package com.gamigo.tracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gamigo.tracker.model.Entry;
import com.gamigo.tracker.model.repository.EntryRepository;

@Controller
@RequestMapping("/entries")
public class EntryController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntryRepository repository;
	
	@ResponseBody
	@RequestMapping(value ="/*", method = RequestMethod.GET)
	public List<Entry> getAllEntries() {
		logger.debug("Reading all entries ...");
		 return repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Entry getEntryById(@PathVariable("id") ObjectId id) {
		return repository.findById(id);
	}
	
	@ResponseBody
	@RequestMapping(value ="/*", method = RequestMethod.POST)
	public Entry createEntry(@Valid @RequestBody Entry entry) {
		entry.setId(ObjectId.get());
		repository.save(entry);
		return entry;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyEntryById(@PathVariable("id") ObjectId id, @Valid @RequestBody Entry entry) {
		entry.setId(id);
		repository.save(entry);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEntry(@PathVariable ObjectId id) {
		repository.delete(repository.findById(id));
	}

}
