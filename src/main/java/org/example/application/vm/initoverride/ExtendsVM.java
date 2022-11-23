package org.example.application.vm.initoverride;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;

public class ExtendsVM {

  private static final Logger LOG = LoggerFactory.getLogger(ExtendsVM.class);

  @Init
  public void init() {
    LOG.info("ExtendsVM.init()");
  }

}
