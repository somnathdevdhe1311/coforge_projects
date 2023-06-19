package com.santander.coforge.postcode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.santander.coforge.postcode.model.PostcodeDetails;

@Repository
public interface PostcodeRepo extends JpaRepository<PostcodeDetails, Integer>{

	@Query(name="select * from postcode_details pd where pd.name=:name and pd.postcode=:postcode",nativeQuery=true)
	PostcodeDetails findByNameAndPostcode(@RequestParam String name, @RequestParam String postcode);

}
