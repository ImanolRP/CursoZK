package org.example.application.vm.carlist;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

public class CarValidator extends AbstractValidator {

  private static final Logger LOG = LoggerFactory.getLogger(CarValidator.class);

  @Override
  public void validate(ValidationContext ctx) {
    Map<String, Property> beanProps =
        ctx.getProperties(ctx.getProperty().getBase());

    String variableFabricante = (String) beanProps.get("make").getValue();

    validarModelo(ctx, (String) beanProps.get("model").getValue());

  }

  private void validarModelo(ValidationContext ctx, String model) {
    if (StringUtils.isBlank(model)) {
      this.addInvalidMessage(ctx, "model", "Modelo erroneo");
    }
  }

}
