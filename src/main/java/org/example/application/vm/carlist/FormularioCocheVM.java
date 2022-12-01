package org.example.application.vm.carlist;

import java.util.Objects;

import org.example.dto.Car;
import org.example.service.carlist.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
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

  private Car nuevoCoche;

  @Init
  public void initFormularioCocheVM(
      @ExecutionArgParam("idCoche") Integer idCoche) {
    if (Objects.isNull(idCoche)) {
      nuevoCoche = new Car();
    } else {
      nuevoCoche = carServiceImpl.findById(idCoche);
    }
  }

  @Command("altaCoche")
  @NotifyChange({"carList", "nuevoCoche"})
  public void altaCoche(@ContextParam(ContextType.VIEW) Component pantalla) {
    carServiceImpl.save(nuevoCoche);
    BindUtils.postGlobalCommand(null, null, "searchCarList", null);
    pantalla.detach();
  }

}
