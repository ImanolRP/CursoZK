package org.example.application.vm.carlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.dto.Car;
import org.example.service.carlist.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

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

  @WireVariable
  private CarService carServiceImpl;

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
    Map<String, Object> argumentos = new HashMap<>();
    argumentos.put("ejemplo", "ejemplo1");
    Executions.createComponents("/vm/carlist/formulario-coche.zul", null,
        argumentos);
  }

}
