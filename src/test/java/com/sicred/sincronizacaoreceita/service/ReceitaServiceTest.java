package com.sicred.sincronizacaoreceita.service;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ReceitaServiceTest {
	 
	
	@Test
	public void verificarAgenciaValida() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertTrue(result);		
	}
	
	@Test
	public void verificarAgenciaNula() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = null;
		String conta = "023456";
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertFalse(result);		
	}
	
	@Test
	public void verificarAgenciaInvalida() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "010";
		String conta = "023456";
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertFalse(result);		
	}
	
	@Test
	public void verificarContaValida() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertTrue(result);		
	}
	
	@Test
	public void verificarContaNula() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = null;
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertFalse(result);		
	}
	
	@Test
	public void verificarContaInvalida() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "02345-6";
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertFalse(result);		
	}
	@Test
	public void verificarStatusValidoA() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "A";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertTrue(result);		
	}
	
	@Test
	public void verificarStatusValidoI() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "I";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertTrue(result);		
	}
	
	@Test
	public void verificarStatusValidoB() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "B";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertTrue(result);		
	}
	
	@Test
	public void verificarStatusValidoP() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "P";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertTrue(result);		
	}
	
	@Test
	public void verificarStatusNulo() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = null;
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertFalse(result);		
	}
	
	@Test
	public void verificarStatusInvalido() throws RuntimeException, InterruptedException {
		ReceitaService receitaService = new ReceitaService();
		String agencia = "0102";
		String conta = "023456";
		double saldo = 233.55;
		String status = "X";
		Boolean result = receitaService.atualizarConta(agencia, conta, saldo, status);
		assertFalse(result);		
	}
	
}
