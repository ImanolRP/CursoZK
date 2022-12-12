package org.example.application.vm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;

import lombok.Getter;

@Getter
public class IndexVM {

  private static final Logger LOG = LoggerFactory.getLogger(IndexVM.class);

  @Init
  public void initIndexVM() {
    LOG.info("IndexVM.initIndexVM()");
  }

}
