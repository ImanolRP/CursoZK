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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarListVM {

  private static final Logger LOG = LoggerFactory.getLogger(CarListVM.class);

  private List<Car> carList;
  private Car selectedCar;
  private CarService service = new CarServiceImpl();
  private String filtro = "";

  @Init
  public void initCarListVM() {
    LOG.info("IndexVM.initIndexVM()");
    carList = service.findAll();
  }

  @Command
  @NotifyChange({"carList"})
  public void search() {
    carList = service.search(filtro);
  }

}
