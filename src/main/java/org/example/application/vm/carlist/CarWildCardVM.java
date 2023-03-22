package org.example.application.vm.carlist;

import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

import lombok.Getter;

@Getter
public class CarWildCardVM {

  private String model;
  private String description;

  @Init
  public void initCarDetailVM(@ExecutionArgParam("model") String model,
      @ExecutionArgParam("description") String description) {
    this.model = model;
    this.description = description;

  }
}
