package org.example.application.vm.initoverride;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;

public class BaseVM extends ExtendsVM {

  private static final Logger LOG = LoggerFactory.getLogger(BaseVM.class);

  @Override
  @Init(superclass = true)
  public void init() {
    LOG.info("BaseVM.init()");
  }

}
