package com.jackson.bakeryordering.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jackson.bakeryordering.model.StaffModel;
import com.jackson.bakeryordering.service.StaffService;
@Controller
public class StaffController {

    private static final Logger logger =
            LoggerFactory.getLogger(StaffController.class);

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }





    @GetMapping("/staff")
    public String viewStaff(Model model) {
        logger.info("Entering StaffController.viewStaff");

        model.addAttribute(
                "staff",
                staffService.getAllStaff()
        );

        logger.info("Exiting StaffController.viewStaff");
        return "staff";
    }





    @GetMapping("/staff/add")
    public String displayAddStaffPage(Model model) {
        logger.info("Entering StaffController.displayAddStaffPage");

        model.addAttribute("staff", new StaffModel());

        logger.info("Exiting StaffController.displayAddStaffPage");
        return "add-staff";
    }





    @PostMapping("/staff/save")
    public String saveStaff(
            @ModelAttribute("staff") StaffModel staff) {

        logger.info("Entering StaffController.saveStaff");

        staffService.saveStaff(staff);

        logger.info("Exiting StaffController.saveStaff");
        return "redirect:/staff";
    }





    @GetMapping("/staff/edit/{id}")
    public String displayEditStaffPage(
            @PathVariable("id") Long id,
            Model model) {

        logger.info("Entering StaffController.displayEditStaffPage");

        StaffModel staff =
                staffService.getStaffById(id);

        model.addAttribute("staff", staff);

        logger.info("Exiting StaffController.displayEditStaffPage");
        return "edit-staff";
    }





    @PostMapping("/staff/update")
    public String editStaff(
            @ModelAttribute("staff") StaffModel staff) {

        logger.info("Entering StaffController.editStaff");

        staffService.saveStaff(staff);

        logger.info("Exiting StaffController.editStaff");
        return "redirect:/staff";
    }





    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable("id") Long id) {
        logger.info("Entering StaffController.deleteStaff");

        staffService.deleteStaff(id);

        logger.info("Exiting StaffController.deleteStaff");
        return "redirect:/staff";
    }
}