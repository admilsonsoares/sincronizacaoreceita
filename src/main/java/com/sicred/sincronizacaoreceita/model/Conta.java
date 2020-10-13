package com.sicred.sincronizacaoreceita.model;

public class Conta {

	private String agencia;

	private String conta;

	private String saldo;

	private String status;

	private boolean statusEnvio;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getContaFormatoEnvio() {
		return conta.replace("-", "");
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSaldo() {
		return saldo;
	}

	public String getSaldoFormatoEnvio() {
		return saldo.replace(",", ".");
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
		;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isStatusEnvio() {
		return statusEnvio;
	}

	public void setStatusEnvio(boolean statusEnvio) {
		this.statusEnvio = statusEnvio;
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", conta=" + conta + ", saldo=" + saldo + ", status=" + status
				+ ", statusEnvio=" + statusEnvio;
	}

}
