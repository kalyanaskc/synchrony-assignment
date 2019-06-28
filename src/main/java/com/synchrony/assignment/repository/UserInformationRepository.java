package com.synchrony.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synchrony.assignment.beans.UserDetails;

/**
 * Repository for user_details table operations
 * */
@Repository
public interface UserInformationRepository extends CrudRepository<UserDetails, Long> {
	public UserDetails findByUserName(@Param("userName") String userName);

}
