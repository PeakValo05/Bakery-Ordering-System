package com.jackson.bakeryordering.repository;

import org.springframework.data.repository.CrudRepository;

import com.jackson.bakeryordering.model.StaffModel;

public interface StaffRepository extends CrudRepository<StaffModel, Long> {
    
}
