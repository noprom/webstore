package com.huntdreams.validator;

import com.huntdreams.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * ProductValidator
 * 结合Spring Validator 和 Bean Validator
 * Created by noprom on 1/30/16.
 */
public class ProductValidator implements Validator {

    @Autowired
    private javax.validation.Validator beanValidator;

    private Set<Validator> springValidators;

    public ProductValidator() {
        springValidators = new HashSet<Validator>();
    }

    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }

    /**
     * 校验Product这个类
     * @param clazz
     * @return
     */
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    /**
     * 分别校验Sping Validator 和 Bean Validator
     * @param target
     * @param errors
     */
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
        for (ConstraintViolation<Object> constraintViolation :constraintViolations) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }
        for(Validator validator: springValidators) {
            validator.validate(target, errors);
        }
    }
}