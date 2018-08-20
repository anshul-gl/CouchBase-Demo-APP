package com.couchbase.demo.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.demo.example.model.Building;
import com.couchbase.demo.example.repositories.BuildingRepository;


import lombok.ToString;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingServices {

    @Autowired
    private BuildingRepository buildingRepository;
    
    public List<Building> findByCompanyId(String companyId) {
        return buildingRepository.findByCompanyId(companyId);
    }

    public Optional<Building> findByPrimaryId(String id)
    {
    	return buildingRepository.findById(id);
    }
    
    public List<Building> getAllBuildings()
    {
		ArrayList<Building> buildings = new ArrayList<>();
		buildingRepository.findAll().forEach(buildings::add);
		return buildings;
    }
//    public List<Building> findByCompanyIdAndNameLike(String companyId, String name, int page) {
//        return buildingRepository.findByCompanyIdAndNameLikeOrderByName(companyId, name, new PageRequest(page, 20))
//                .getContent();
//    }
//
// 
//    public Building findByCompanyAndAreaId(String companyId, String areaId) {
//        return buildingRepository.findByCompanyAndAreaId(companyId, areaId);
//    }
//
//   
//    public List<Building> findByPhoneNumber(String telephoneNumber) {
//        return buildingRepository.findByPhoneNumber(telephoneNumber);
//    }
//
   
//    public Building findById(String buildingId) {
//        return buildingRepository.findOne(buildingId);
//    }


    public String save(@Valid Building building) {
    	JsonObject response = JsonObject.create();
        buildingRepository.save(building);
        response.put("result", "success");
        return response.toString();
    }

  
    public String updateBuilding(String id, Building theBuilding)
    {
      	JsonObject response = JsonObject.create();
      	try {
      		Building building = buildingRepository.findById(id).get();
      		if (building != null) {
      			buildingRepository.save(theBuilding);
      			response.put("result", "success");
      			
      		}
      	}
      	catch (Exception e) {
 			response.put("result", "ID NOT FOUND");
		}
		return response.toString();
    }

    public String deleteBuilding(String id)
    {
    	
      	JsonObject response = JsonObject.create();
      	try {
      		Building building = buildingRepository.findById(id).get();
      		if (building != null) {
      			buildingRepository.delete(building);
      			response.put("result", "success");
      			
      		}
      	}
      	catch (Exception e) {
 			response.put("result", "ID NOT FOUND");
		}
		return response.toString();    	
    }

}
