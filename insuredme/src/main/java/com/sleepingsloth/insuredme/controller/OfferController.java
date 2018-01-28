package com.sleepingsloth.insuredme.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.OfferRepository;
import com.sleepingsloth.insuredme.dao.UserRepository;
import com.sleepingsloth.insuredme.domain.Offer;
import com.sleepingsloth.insuredme.model.OfferModel;

@Controller
@RequestMapping(path = "/offer")
public class OfferController {
	private static final Logger LOGGER = Logger.getLogger(OfferController.class.getName());

	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody Long addNewQuote(@RequestBody Offer offer) {
		offerRepository.save(offer);
		LOGGER.info("Offer saved with id: " + offer.getId());
		return offer.getId();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Offer> getAllOffers() {
		return offerRepository.findAll();
	}

	@GetMapping(path = "/findForUser")
	public @ResponseBody Iterable<Offer> getAllOffersForUser(@RequestParam long userId) {
		LOGGER.info("Selecting offers for user: " + userId);
		return offerRepository.findByUserIdOrderById(userId);
	}
	
	
	@GetMapping(path = "/findForQuote")
	public @ResponseBody Iterable<OfferModel> getAllOffersForQuote(@RequestParam long quoteRequestId) {
		LOGGER.info("Selecting offers for quote: " + quoteRequestId);
		Iterable<Offer> offers = offerRepository.findByQuoteRequestIdOrderByPrice(quoteRequestId);
		List<OfferModel> offersModel = new ArrayList<OfferModel>();
		for(Offer offer : offers) {
			OfferModel offerModel = new OfferModel();
			offerModel.setOffer(offer);
			offerModel.setUser(userRepository.findOne(offer.getUserId()));
			offersModel.add(offerModel);
		}
		return offersModel;
	}
	
	
	@GetMapping(path = "/find")
	public @ResponseBody OfferModel getOffer(@RequestParam long offerId) {
		LOGGER.info("Selecting offers with id: " + offerId);
		Offer offer = offerRepository.findOne(offerId);
		OfferModel offerModel = new OfferModel();
		offerModel.setOffer(offer);
		offerModel.setUser(userRepository.findOne(offer.getUserId()));
		return offerModel;
	}
}
