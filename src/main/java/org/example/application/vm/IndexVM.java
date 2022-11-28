package org.example.application.vm;

import org.example.application.comun.PantallasEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.event.Event;

import lombok.Getter;

@Getter
public class IndexVM {

  private static final Logger LOG = LoggerFactory.getLogger(IndexVM.class);

  private String pathCentro;

  @Init
  public void initIndexVM() {
    LOG.info("IndexVM.initIndexVM()");
  }

  @Command("navegarA")
  @GlobalCommand("navegarA")
  @NotifyChange("pathCentro")
  public void navegarA(Event e, @BindingParam("path") PantallasEnum ruta) {
    LOG.info("command");
    pathCentro = ruta.getPath();
  }

}
