package org.example.application.comun;

import lombok.Getter;

@Getter
public enum PantallasEnum {

  CARLIST("/vm/carlist/carlist.zul"), //
  EXTENDS("/vm/initoverride/base.zul"), //
  BASE("/vm/myviewmodel/myviewmodel.zul"), //
  FORMULARIO("/vm/formulario/formulario.zul");//

  String path;

  PantallasEnum(String path) {
    this.path = path;
  }

}
