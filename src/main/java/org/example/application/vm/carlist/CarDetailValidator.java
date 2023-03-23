package org.example.application.vm.carlist;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

import java.util.List;
import java.util.Map;

public class CarDetailValidator extends AbstractValidator {

  List<String> marcas;

  @Override
  public void validate(ValidationContext ctx) {
    Map<String, Property> propiedades =
        ctx.getProperties(ctx.getProperty().getBase());

    validarMarca(ctx, (String) propiedades.get("make").getValue(),
        (List<String>) ctx.getValidatorArg("listadoMarcas"));
  }

  private void validarMarca(ValidationContext ctx, String make,
      List<String> listadoMarcas) {
    if (StringUtils.isBlank(make)) {
      this.addInvalidMessage(ctx, "make",
          "El fabricante no puede quedar vacio");
    } else if (isNotMarcaValida(make)) {
      this.addInvalidMessage(ctx, "make", "Esa marca no es valida");
    }
  }

  private boolean isNotMarcaValida(String make) {
    return false;
  }

}
