/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import data.Duration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Benjamin
 */
public class FollowingValidator implements ConstraintValidator<Following, Duration> {

  @Override
  public void initialize(Following constraintAnnotation) {
  }

  @Override
  public boolean isValid(Duration value, ConstraintValidatorContext context) {
    return (!value.getStart().before(value.getFinish())
            || !value.getFinish().after(value.getStart()));
  }

}
