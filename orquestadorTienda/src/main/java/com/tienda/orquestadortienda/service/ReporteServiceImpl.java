package com.tienda.orquestadortienda.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ConsultaService  consultaService;
    private final TemplateEngine templateEngine;

    @Override
    public String obtenerReportePorProveedorId(long id) {

        Context contex = new Context();
        contex.setVariable("proveedorDatos", consultaService.consultarProveedorPorId(id));

        String reporte=  templateEngine.process("reporteProveedor", contex);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(reporte, outputStream, converterProperties);

        byte[] bytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(bytes);
    }

}
