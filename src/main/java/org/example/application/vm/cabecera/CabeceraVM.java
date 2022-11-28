package org.example.application.vm.cabecera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;

public class CabeceraVM {

  private static final Logger LOG = LoggerFactory.getLogger(CabeceraVM.class);

  @Init
  public void initCabeceraVM() {
    LOG.info("CabeceraVM.initCabeceraVM()");
  }

}
