package com.sbc.projects.RESTfulServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbc.projects.RESTfulServices.service.additional.Name;
import com.sbc.projects.RESTfulServices.service.additional.NameV1;
import com.sbc.projects.RESTfulServices.service.additional.NameV2;

@RestController
public class VersioningController {

/**
 * FOUR TYPES OF VERSIONING -
 * 1. Mime Type or 'Content-Negotiation' or 'Accept-Header Type'
 * 2. Header Type
 * 3. URI Type
 * 4. Request Parameter Type
 * 
 */
	

	/**
	 * --------------------- 1. MIME TYPE or ACCEPT-HEADER Versioning ---------------------------------
	 * 
	 * @param: http://localhost:8080/name/produces
	 * @Header: Accept = application/v1+json, Accept = application/v2+json
	 */
	@GetMapping(value="/name/produces", produces="application/v1+json")
	public NameV1 getNameProducesV1(){
		
		NameV1 name = new NameV1("Surya Chettri");
		return name;
	}
	
	@GetMapping(value="/name/produces", produces="application/v2+json")
	public NameV2 getNameProducesV2(){
		
		NameV2 name = new NameV2(new Name("Surya", "Chettri"));
		return name;
	}
	
	
	/**
	 * --------------------- 2. HEADER Versioning ---------------------------------
	 * 
	 * @param: http://localhost:8080/name/headers
	 * @Header: VERSION = 1, VERSION = 2
	 */
	@GetMapping(value="/name/headers", headers="VERSION=1")
	public NameV1 getNameHeadersV1(){
		
		NameV1 name = new NameV1("Surya Chettri");
		return name;
	}
	
	@GetMapping(value="/name/headers", headers="VERSION=2")
	public NameV2 getNameHeadersV2(){
		
		NameV2 name = new NameV2(new Name("Surya", "Chettri"));
		return name;
	}
		
	
	/**
	 * --------------------- 3. URI Versioning ---------------------------------
	 * 
	 * @param: http://localhost:8080/name/v1, http://localhost:8080/name/v1
	 */
	@GetMapping(value="/name/v1")
	public NameV1 getNameV1(){
		
		NameV1 name = new NameV1("Surya Chettri");
		return name;
	}
	
	@GetMapping(value="/name/v2")
	public NameV2 getNameV2(){
		
		NameV2 name = new NameV2(new Name("Surya", "Chettri"));
		return name;
	}
	

	/**
	 * --------------------- 4. REQUEST PARAM Versioning ---------------------------------
	 * 
	 * @param: http://localhost:8080/name/params?v=1, http://localhost:8080/name/params?v=2
	 */
	@GetMapping(value="/name/params", params="v=1")
	public NameV1 getNameParamsV1(){
		
		NameV1 name = new NameV1("Surya Chettri");
		return name;
	}
	
	@GetMapping(value="/name/params", params="v=2")
	public NameV2 getNameParamsV2(){
		
		NameV2 name = new NameV2(new Name("Surya", "Chettri"));
		return name;
	}
	
	
	
	
	
	
	
	
}
