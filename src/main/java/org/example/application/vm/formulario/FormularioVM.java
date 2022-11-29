package org.example.application.vm.formulario;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormularioVM {

  private static final Logger LOG = LoggerFactory.getLogger(FormularioVM.class);

  private Form ejemploForm = new Form();

  @Init
  public void initFormularioVM() {
    LOG.info("FormularioVM.initFormularioVM()");
  }

  @Command("guardar")
  public void guardar() {
    LOG.info("guardar");
  }

}
