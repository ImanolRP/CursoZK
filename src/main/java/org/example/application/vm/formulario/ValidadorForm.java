package org.example.application.vm.formulario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

public class ValidadorForm extends AbstractValidator {

  private static final Logger LOG =
      LoggerFactory.getLogger(ValidadorForm.class);

  @Override
  public void validate(ValidationContext ctx) {
    LOG.info("validate");
  }
}
