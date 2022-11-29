package org.example.application.vm.formulario;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Form {

  private String varString;
  private String varPassword;
  private Integer varInteger;
  private Double varDouble;
  private Date varDate;

}
