package org.example.application.vm.carlist;

import org.example.dto.CarDTO;
import org.example.service.carlist.CarService;
import org.example.service.carlist.CarServiceImpl;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarListVM {

    private String prueba = "Hola mundo";
    private List<CarDTO> listadoCoches = new ArrayList<>();
    private CarDTO selectedCar;

    private CarService carServiceImpl = new CarServiceImpl();

    @Init
    public void initCarListVM(){
        listadoCoches = carServiceImpl.findAll();
        selectedCar = listadoCoches.get(0);
    }

    @Command("editarCoche")
    public void abrirPopup() {
      Map<String, Object> arg = new HashMap<>();
      arg.put("modo", "edicion");
      arg.put("cocheSeleccionado", selectedCar);
      Executions.createComponents("/vm/carlist/car-detail.zul", null, arg);
    }

    @Command("detalleCoche")
    public void detalleCoche(@BindingParam("cocheDobleClick") CarDTO coche,
        @BindingParam("asdf") String asdf) {
      Map<String, Object> arg = new HashMap<>();
      arg.put("modo", "detalle");
      arg.put("cocheSeleccionado", coche);
      Executions.createComponents("/vm/carlist/car-detail.zul", null, arg);
    }

    public List<CarDTO> getListadoCoches() {
        return listadoCoches;
    }

    public String getPrueba() {
        return prueba;
    }

    public CarDTO getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(CarDTO selectedCar) {
        this.selectedCar = selectedCar;
    }
}
