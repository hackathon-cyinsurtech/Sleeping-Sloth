package com.sleepingsloth.insuredme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.PhotoRepository;
import com.sleepingsloth.insuredme.dao.QuoteRequestRepository;
import com.sleepingsloth.insuredme.domain.Photo;
import com.sleepingsloth.insuredme.domain.QuoteRequest;

@Controller
@RequestMapping(path="/photo")
public class PhotoController {
	
	private static final Logger LOGGER = Logger.getLogger( PhotoController.class.getName() );
	
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private QuoteRequestRepository quoteRequestRepository;

	@PostMapping(path="/add")
	public @ResponseBody Long addPhoto (@RequestBody Photo photo) {
		LOGGER.info("Processing photo for : " + photo.getQuoteRequestId());
		photoRepository.save(photo);
		QuoteRequest quote = quoteRequestRepository.findOne(photo.getQuoteRequestId());
		
		if (!quote.isPhotosTaken()) {
			quote.setPhotosTaken(true);
			quoteRequestRepository.save(quote);
		}

		LOGGER.info("Photo has been saved with id: " + photo.getId());
		return photo.getId();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Photo> getAllPhotos() {
		LOGGER.info("Selecting all photos");
		return photoRepository.findAll();
	}
	
	
	@GetMapping(path="/find")
	public @ResponseBody Iterable<Photo> getAllPhotosForQuote(@RequestParam long quoteRequestId) {
		LOGGER.info("Selecting all photos for quoteRequestId: " + quoteRequestId);
		return photoRepository.findByQuoteRequestId(quoteRequestId);
	}
}

