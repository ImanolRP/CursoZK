package org.example.application.vm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class IndexVM {

  private static final Logger LOG = LoggerFactory.getLogger(IndexVM.class);

  private int count;

  @Init
  public void initIndexVM() {
    LOG.info("IndexVM.initIndexVM()");
    count = 100;
  }

  @Command
  @NotifyChange("count")
  public void cmd() {
    ++count;
  }

  public int getCount() {
    return count;
  }

}
