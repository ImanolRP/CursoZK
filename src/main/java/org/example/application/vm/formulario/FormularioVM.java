package org.example.application.vm.formulario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;

public class FormularioVM {

  private static final Logger LOG = LoggerFactory.getLogger(FormularioVM.class);

  @Init
  public void initFormularioVM() {
    LOG.info("FormularioVM.initFormularioVM()");
  }

}
