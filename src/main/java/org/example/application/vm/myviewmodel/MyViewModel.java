package org.example.application.vm.myviewmodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
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

  @Command({"sumaUno"})
  public void sumaUno() {
    ++count;
    BindUtils.postNotifyChange(null, null, this, "count");
  }

  @Command({"sumaUnisimo"})
  public void sumaUnisimo() {
    // hacen cosas
    sumaUno();
  }

  @Command({"masUno"})
  public void masUno() {
    // hacen cosas
    sumaUno();
  }

  public int getCount() {
    return count;
  }

}
