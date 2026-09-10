package com.jackson.bakeryordering.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "staff_first_name")
    private String staffFirstName;

    @Column(name = "staff_last_name")
    private String staffLastName;

    @Column(name = "staff_email")
    private String staffEmail;

    @Column(name = "staff_phone_number")
    private String staffPhoneNumber;

    @Column(name = "staff_role")
    private String staffRole;   

    @Column(name = "staff_address")
    private String staffAddress;

    @Column(name = "staff_contact_address")
    private String staffContactAddress;

    @Column(name = "staff_contact_email")
    private String staffContactEmail;

    @Column(name = "staff_contact_phone")
    private String staffContactPhone;

    public Long getStaffId() {
        return staffId;
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public String getStaffLastName() {
        return staffLastName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public String getStaffContactAddress() {
        return staffContactAddress;
    }

    public String getStaffContactEmail() {
        return staffContactEmail;
    }

    public String getStaffContactPhone() {
        return staffContactPhone;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = staffFirstName;
    }

    public void setStaffLastName(String staffLastName) {
        this.staffLastName = staffLastName;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public void setStaffContactAddress(String staffContactAddress) {
        this.staffContactAddress = staffContactAddress;
    }

    public void setStaffContactEmail(String staffContactEmail) {
        this.staffContactEmail = staffContactEmail;
    }

    public void setStaffContactPhone(String staffContactPhone) {
        this.staffContactPhone = staffContactPhone;
    }
}
