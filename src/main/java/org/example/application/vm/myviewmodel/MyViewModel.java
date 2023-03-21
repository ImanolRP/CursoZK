package org.example.application.vm.myviewmodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {

  private static final Logger LOG = LoggerFactory.getLogger(MyViewModel.class);

  private int count;

  @Init
  public void initMyViewModel() {
    // commit de prueba
    LOG.info("MyViewModel.initMyViewModel()");
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
