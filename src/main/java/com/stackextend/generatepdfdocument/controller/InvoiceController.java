package com.stackextend.generatepdfdocument.controller;

import com.stackextend.generatepdfdocument.model.OrderModel;
import com.stackextend.generatepdfdocument.service.InvoiceService;
import com.stackextend.generatepdfdocument.service.MockOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_PDF;

@Controller
@RequestMapping("/invoice/generator")
public class InvoiceController {

    static private Logger logger = LogManager.getLogger(InvoiceController.class);

    @Resource
    private MockOrderService mockOrderService;
    @Resource
    private InvoiceService invoiceService;

    // display invoice generator : /resources/templates/forms.html
    @GetMapping("/forms")
    public String invoiceForms() {
        return "forms";
    }

    // generate invoice pdf
    @PostMapping(value = "/generate", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> invoiceGenerate(@RequestParam(name = "code", defaultValue = "XYZ123456789") String code,
                                                               @RequestParam(name = "lang", defaultValue = "en") String lang) throws IOException {
        logger.info("Start invoice generation...");
        final OrderModel order = mockOrderService.getOrderByCode(code);
        final File invoicePdf = invoiceService.generateInvoiceFor(order, Locale.forLanguageTag(lang));
        logger.info("Invoice generated successfully...");

        final HttpHeaders httpHeaders = getHttpHeaders(code, lang, invoicePdf);
        return new ResponseEntity<>(new InputStreamResource(new FileInputStream(invoicePdf)), httpHeaders, OK);
    }

    private HttpHeaders getHttpHeaders(String code, String lang, File invoicePdf) {
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentType(APPLICATION_PDF);
        respHeaders.setContentLength(invoicePdf.length());
        respHeaders.setContentDispositionFormData("attachment", format("%s-%s.pdf", code, lang));
        return respHeaders;
    }
}
