package org.example.application.vm;

import org.example.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import lombok.Getter;

@Getter
@VariableResolver(DelegatingVariableResolver.class)
public class IndexVM {

  private static final Logger LOG = LoggerFactory.getLogger(IndexVM.class);

  @WireVariable
  PokemonService pokemonServiceImpl;

  @Init
  public void initIndexVM() {
    LOG.info("IndexVM.initIndexVM()");
  }

}
