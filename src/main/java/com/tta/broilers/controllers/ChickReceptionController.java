package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.ChickReceptionInterface;
import com.tta.broilers.entities.ChickReception;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/chickReception")
public class ChickReceptionController {

	@Autowired
	ChickReceptionInterface chickReceptionInterface;

	@GetMapping
	public List<ChickReception> findAll() {

		return chickReceptionInterface.findAll();
	}



	

	@PostMapping("/save")
	public BasicResponse save(@RequestBody ChickReception chickReception) {
		System.out.println("chickReception farm" + chickReception.toString());
		return chickReceptionInterface.save(chickReception);
	}

}
