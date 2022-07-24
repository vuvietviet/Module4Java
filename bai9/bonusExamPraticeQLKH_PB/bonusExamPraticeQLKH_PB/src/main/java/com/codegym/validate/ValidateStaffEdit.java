package com.codegym.validate;

import com.codegym.model.Staff;
import com.codegym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ValidateStaffEdit implements Validator {
    @Autowired
    StaffService staffService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Staff staff = (Staff) target;
        if ((staff.getAge() < 18) && (staff.getAge() > 55)) {
            errors.rejectValue("age","error Age","Age >= 18 and <= 55");
        }
        if (!staff.getName().matches("(^[A-Z][A-Za-z\\s]+)")){
            errors.rejectValue("name", "error Name","Include only alphabetic characters and the first alphabetic character of the uppercase");
        }

    }
}
