package com.sicred.sincronizacaoreceita.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationArguments;

public class ProcessarArquivoTest {

	@Test
	public void arquivoInexistente() {
		ProcessarArquivo processarArquivo = new ProcessarArquivo();
		ApplicationArguments arquivo = null;

		Assertions.assertThrows(NullPointerException.class, () -> {
			processarArquivo.processarArquivoCSVJob(arquivo);
		});
	}
}
