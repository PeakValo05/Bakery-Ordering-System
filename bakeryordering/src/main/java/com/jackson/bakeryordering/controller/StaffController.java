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
        logger.info("Entering viewStaff");

        model.addAttribute(
                "staff",
                staffService.getAllStaff()
        );

        logger.info("Exiting viewStaff");
        return "staff";
    }

    @GetMapping("/staff/add")
    public String displayAddStaffPage(Model model) {
        logger.info("Entering displayAddStaffPage");

        model.addAttribute("staff", new StaffModel());

        logger.info("Exiting displayAddStaffPage");
        return "add-staff";
    }

    @PostMapping("/staff/save")
    public String saveStaff(
            @ModelAttribute("staff") StaffModel staff) {

        logger.info("Entering saveStaff");

        staffService.saveStaff(staff);

        logger.info("Staff saved successfully");
        return "redirect:/staff";
    }

    @GetMapping("/staff/edit/{id}")
    public String displayEditStaffPage(
            @PathVariable("id") Long id,
            Model model) {

        logger.info("Entering displayEditStaffPage");

        StaffModel staff =
                staffService.getStaffById(id);

        model.addAttribute("staff", staff);

        logger.info("Exiting displayEditStaffPage");
        return "edit-staff";
    }

    @PostMapping("/staff/update")
    public String editStaff(
            @ModelAttribute("staff") StaffModel staff) {

        logger.info("Entering editStaff");

        staffService.saveStaff(staff);

        logger.info("Staff updated successfully");
        return "redirect:/staff";
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable("id") Long id) {
        logger.info("Entering deleteStaff");

        staffService.deleteStaff(id);

        logger.info("Staff deleted successfully");
        return "redirect:/staff";
    }
}