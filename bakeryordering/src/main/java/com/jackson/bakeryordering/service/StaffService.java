package com.jackson.bakeryordering.service;

import org.springframework.stereotype.Service;

import com.jackson.bakeryordering.model.StaffModel;
import com.jackson.bakeryordering.repository.StaffRepository;


@Service    
public class StaffService {


    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Iterable<StaffModel> getAllStaff() {
        return staffRepository.findAll();
    }

    public void saveStaff(StaffModel staff) {
        staffRepository.save(staff);
    }

    public StaffModel getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

}
