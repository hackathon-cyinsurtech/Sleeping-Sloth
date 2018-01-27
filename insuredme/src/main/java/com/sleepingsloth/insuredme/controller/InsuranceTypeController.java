package com.sleepingsloth.insuredme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.InsuranceTypeRepository;
import com.sleepingsloth.insuredme.domain.InsuranceType;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Controller
@RequestMapping(path="/insurancetype")
public class InsuranceTypeController {
	
	private static final Logger LOGGER = Logger.getLogger( InsuranceTypeController.class.getName() );
	
	@Autowired
	private InsuranceTypeRepository insuranceTypeRepository;

	@PostMapping(path="/add")
	public @ResponseBody String addInsuranceType (@RequestBody InsuranceType insuranceType) {
		insuranceTypeRepository.save(insuranceType);
		LOGGER.info("Insurance type '" + insuranceType.getCode() + "' has been saved");
		return insuranceType.getCode();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<InsuranceType> getAllInsuranceType() {
		LOGGER.info("Selecting all insurance types");
		return insuranceTypeRepository.findAll();
	}
}
