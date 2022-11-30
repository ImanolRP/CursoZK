package org.example.application.vm.carlist;

import org.example.dto.Car;
import org.example.service.carlist.CarService;
import org.example.service.carlist.CarServiceImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class FormularioCocheVM {

  private CarService carServiceImpl = new CarServiceImpl();

  private Car nuevoCoche = new Car();

  @Init
  public void initFormularioCocheVM() {
    int i = 0;
  }

  @Command("altaCoche")
  @NotifyChange({"carList", "nuevoCoche"})
  public void altaCoche() {
    carServiceImpl.save(nuevoCoche);
    nuevoCoche = new Car();
  }

}
