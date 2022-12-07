package com.brq.ms07.delegates;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named("aprovarCadastro")
public class AprovarCadastroDelegate
	implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.info("Aprovar Cadastro....");
	}

}
