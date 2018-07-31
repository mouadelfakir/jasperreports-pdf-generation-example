package com.stackextend.generatepdfdocument;

import com.stackextend.generatepdfdocument.model.OrderModel;
import com.stackextend.generatepdfdocument.service.InvoiceService;
import com.stackextend.generatepdfdocument.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Locale;


@SpringBootApplication
public class GeneratePdfDocumentApplication implements CommandLineRunner {

    Logger log = LogManager.getLogger(GeneratePdfDocumentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GeneratePdfDocumentApplication.class, args);
	}

	@Resource
	private OrderService orderService;
	@Resource
    private InvoiceService invoiceService;

	@Override
	public void run(String... args) throws Exception {
        log.info("Start invoice generation...");

        OrderModel order = orderService.getOrderByCode("XYZ123456789");

        invoiceService.generateInvoiceFor(order, Locale.FRANCE);

        log.info("Invoice generated successfully...");
	}
}
