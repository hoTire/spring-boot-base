package com.googlecode.hotire.base.utils;

import com.googlecode.hotire.base.domain.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return Person.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    Person person = (Person) o;
    if (person.getAge() < 20) {
      errors.rejectValue("age", "청소년", "성인이 아닙니다.");
    }
  }
}
