package org.example.application.vm.carlist;

import java.util.List;

import org.example.dto.Car;
import org.example.service.carlist.CarService;
import org.example.service.carlist.CarServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CarListVM {

  private static final Logger LOG = LoggerFactory.getLogger(CarListVM.class);

  private List<Car> carList;
  private Car selectedCar;
  private String filtro = "";

  private CarService carServiceImpl = new CarServiceImpl();

  @Init
  public void initCarListVM() {
    LOG.info("IndexVM.initIndexVM()");
    carList = carServiceImpl.findAll();
  }

  @Command
  @NotifyChange({"carList"})
  public void search() {
    carList = carServiceImpl.search(filtro);
  }

  @Command("abrirFormulario")
  public void abrirFormulario() {
    Executions.createComponents("/vm/carlist/formulario-coche.zul", null, null);
  }

}
