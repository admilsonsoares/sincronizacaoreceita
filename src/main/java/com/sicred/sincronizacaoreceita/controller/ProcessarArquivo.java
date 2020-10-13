package com.sicred.sincronizacaoreceita.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.sicred.sincronizacaoreceita.model.Conta;
import com.sicred.sincronizacaoreceita.service.ReceitaService;

@EnableBatchProcessing
@Component
public class ProcessarArquivo {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ReceitaService receitaService;

	@Bean
	public Job processarArquivoCSVJob(ApplicationArguments args) {
		return jobBuilderFactory.get("processarArquivoCSVJob").start(processarArquivoCSVSteps(args.getSourceArgs()))
				.build();
	}

	public Step processarArquivoCSVSteps(String[] arquivoRecebido) {
		return stepBuilderFactory.get("processarArquivoCSVSteps").tasklet(new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

				List<Conta> contas = extrairConteudoRecebido(arquivoRecebido);

				FileWriter writer = new FileWriter("retaguardaEnviado.csv");

				StatefulBeanToCsvBuilder<Conta> builder = new StatefulBeanToCsvBuilder<Conta>(writer);

				StatefulBeanToCsv<Conta> beanWriter = builder.withSeparator(';').withApplyQuotesToAll(false)
						.withOrderedResults(false).build();

				for (Conta conta : contas) {
					conta.setStatusEnvio(receitaService.atualizarConta(conta.getAgencia(), conta.getContaFormatoEnvio(),
							Double.parseDouble(conta.getSaldoFormatoEnvio()), conta.getStatus()));
				}

				beanWriter.write(contas);
				writer.flush();
				writer.close();

				return RepeatStatus.FINISHED;
			}

		}).build();
	}

	private List<Conta> extrairConteudoRecebido(String[] arquivoRecebido) throws IOException {

		FileReader arquivo = new FileReader(arquivoRecebido[0]);

		BufferedReader arquivoCSV = new BufferedReader(arquivo);

		List<Conta> contas = new CsvToBeanBuilder<Conta>(arquivoCSV).withType(Conta.class).withSeparator(';').build()
				.parse();
		return contas;
	}

}
