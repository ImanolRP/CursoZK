package org.example.application.vm.carlist;

import org.example.dto.CarDTO;
import org.example.service.carlist.CarService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CarDetailVM {

  private String modo;
  private CarDTO coche;

  @WireVariable
  private CarService carServiceImpl;

  @Init
  public void initCarDetailVM(@ExecutionArgParam("modo") String modo,
      @ExecutionArgParam("cocheSeleccionado") CarDTO cocheSeleccionado) {
    this.modo = modo;
    this.coche = cocheSeleccionado;
  }

  @Command("submit")
  public void submit(@ContextParam(ContextType.VIEW) Component popup) {
    carServiceImpl.editar(coche);
    popup.detach();
  }

}
