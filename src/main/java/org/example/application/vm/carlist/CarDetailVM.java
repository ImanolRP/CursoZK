package org.example.application.vm.carlist;

import org.example.dto.CarDTO;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDetailVM {

  private String modo;
  private CarDTO coche;

  @Init
  public void initCarDetailVM(@ExecutionArgParam("modo") String modo,
      @ExecutionArgParam("cocheSeleccionado") CarDTO cocheSeleccionado) {
    this.modo = modo;
    this.coche = cocheSeleccionado;
  }
}
