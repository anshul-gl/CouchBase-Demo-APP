package com.couchbase.demo.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.demo.example.model.Building;
import com.couchbase.demo.example.services.BuildingServices;
import java.util.*;
@RestController

@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	private BuildingServices buildingService;
	
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String addBuilding(@RequestBody Building theBuilding)
	{
		return buildingService.save(theBuilding);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public Optional<Building> getBuildingById(@PathVariable String id)
	{
		return buildingService.findByPrimaryId(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)	
	public List<Building> getAllBuildings()
	{
		return buildingService.getAllBuildings();
	}

	@RequestMapping(value = "/{id}",method=RequestMethod.PUT)
	public String updateBuilding(@PathVariable String id, @RequestBody Building theBuilding)
	{
		return buildingService.updateBuilding(id,theBuilding);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public String deleteBuilding(@PathVariable String id)
	{
		return buildingService.deleteBuilding(id);
	}
}
