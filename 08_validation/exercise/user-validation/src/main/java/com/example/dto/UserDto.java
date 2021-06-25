package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank(message = "Không được rỗng")
    @Size(min = 2,max = 10,message = "Tên từ 2 đến 10 kí tự")
    private String fistName;
    @NotBlank(message = "Không được rỗng")
    @Size(min = 2,max = 10,message = "Tên từ 2 đến 10 kí tự")
    private String lastName;
    private String phone;
    @Email(message = "Email chưa đúng định dạng")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
UserDto userDto = (UserDto) target;
        if (!userDto.phone.matches("^0\\d{9,10}$")){
            errors.rejectValue("phone","phone.invalidFormat","Invalid format phone number");
        }

    }
}
