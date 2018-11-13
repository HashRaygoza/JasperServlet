/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pydee.jasperservlet.reporte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mx.com.pydee.jasperservlet.vo.RegistroFacturaVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author David
 */
public class Factura {
    public byte[] generarPdf() throws JRException, IOException {
        Map parametros = (Map) new HashMap<>();
        
        parametros.put("estacion", "Central de Abastos");
        parametros.put("direccionEstacion", "Ricardo Anaya #333");
        parametros.put("telefonoEstacion", "88-88-88");
        parametros.put("rncEstacion", "CAB3232323RR");
        parametros.put("emailEstacion", "abastos@cabastos.com.mx");
        
        parametros.put("cliente", "Cliente de prueba");
        parametros.put("direccionCliente", "Dirección de prueba");
        parametros.put("rncCliente", "PRU3232323RRR");
        parametros.put("telefonoCliente", "77-77-77");
        parametros.put("e-mail", "prueba@cliente.net");
        parametros.put("ncf", "A9999");
        parametros.put("fechaNCF", "2018-11-13");
        parametros.put("total", "999.99");
        
        JasperReport reporte = this.inicializarReporte();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.conceptos());
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, dataSource);
        
        return JasperExportManager.exportReportToPdf(jasperPrint);
        
    }
    
    private ArrayList<RegistroFacturaVO> conceptos() {
        ArrayList<RegistroFacturaVO> listaConceptos = new ArrayList<>();
        
        listaConceptos.add( new RegistroFacturaVO("1", "Producto 1", 100.0, 0.16, 2.0, 200.0, "00010", 10, 0.0) );
        listaConceptos.add( new RegistroFacturaVO("2", "Producto 2", 100.0, 0.16, 2.0, 200.0, "00011", 11, 0.0) );
        listaConceptos.add( new RegistroFacturaVO("3", "Producto 3", 100.0, 0.16, 2.0, 200.0, "00012", 12, 0.0) );
        listaConceptos.add( new RegistroFacturaVO("4", "Producto 4", 100.0, 0.16, 2.0, 200.0, "00013", 13, 0.0) );
        listaConceptos.add( new RegistroFacturaVO("5", "Producto 5", 199.99, 0.16, 1.0, 199.99, "00014", 14, 0.0) );        
        
        return listaConceptos;
    }
    
    public JasperReport inicializarReporte() throws FileNotFoundException, JRException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("formato.jrxml").getFile());
       
        JasperReport jasperReport;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
        }
        
        return jasperReport;        
    }
    
}
