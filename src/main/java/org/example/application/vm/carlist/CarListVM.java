package org.example.application.vm.carlist;

import org.example.application.vm.myviewmodel.MyViewModel;
import org.example.dto.CarDTO;
import org.example.service.carlist.CarService;
import org.example.service.carlist.CarServiceImpl;
import org.zkoss.bind.annotation.Init;

import java.util.ArrayList;
import java.util.List;

public class CarListVM {

    private String prueba = "Hola mundo";
    private List<CarDTO> listadoCoches = new ArrayList<>();

    private CarService carServiceImpl = new CarServiceImpl();

    @Init
    public void initCarListVM(){
        listadoCoches = carServiceImpl.findAll();
    }

    public List<CarDTO> getListadoCoches() {
        return listadoCoches;
    }

    public String getPrueba() {
        return prueba;
    }
}
