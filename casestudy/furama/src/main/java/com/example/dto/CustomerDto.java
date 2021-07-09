package com.example.dto;

import com.example.model.entity.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private Integer id;
    @NotBlank
    private String code;
    @NotBlank(message = "Invalid")
    private String name;
    @NotBlank
    private String birthday;
    private String gender;
    @NotBlank
    private String idCard;
    @NotBlank
    private String phone;
    @Email
    private String email;
    private String address;
    private CustomerType customerType;
    private boolean flag = true;

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.code.matches("^KH-[0-9]{4}$")){
            errors.rejectValue("code","customer.validCode","Code format: KH-XXXX");
        }
        if (!customerDto.phone.matches("^(090|091)[0-9]{7}$")) {
            errors.rejectValue("phone", "customer.validPhone", "Customer phone format 091xxxxxxx or 090xxxxxxx");
        }
        if (!customerDto.idCard.matches("^[0-9]{9,10}$")) {
            errors.rejectValue("idCard", "customer.validIdCard", "Customer id card format XXXXXXXXX or XXXXXXXXXXXX ");
        }
    }
}
