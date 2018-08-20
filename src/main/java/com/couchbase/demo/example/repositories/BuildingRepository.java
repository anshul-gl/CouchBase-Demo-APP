package com.couchbase.demo.example.repositories;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.couchbase.demo.example.model.Building;

import java.util.List;

	@N1qlPrimaryIndexed
	@ViewIndexed(designDoc = "building")
	public interface BuildingRepository extends CouchbaseRepository<Building, String> {

	    List<Building> findByCompanyId(String companyId);

	
}
