package org.example.application.vm.carlist;

import org.example.dto.Car;
import org.example.service.carlist.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class FormularioCocheVM {

  private static final Logger LOG =
      LoggerFactory.getLogger(FormularioCocheVM.class);

  @WireVariable
  private CarService carServiceImpl;

  private Car nuevoCoche = new Car();

  @Init
  public void initFormularioCocheVM(
      @ExecutionArgParam("ejemplo") String input) {
    int i = 0;
  }

  @Command("altaCoche")
  @NotifyChange({"carList", "nuevoCoche"})
  public void altaCoche() {
    carServiceImpl.save(nuevoCoche);
    nuevoCoche = new Car();
  }

}
