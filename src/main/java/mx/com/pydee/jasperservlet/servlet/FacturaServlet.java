/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pydee.jasperservlet.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.pydee.jasperservlet.reporte.Factura;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author David
 */
@WebServlet("/facturaPdf")
public class FacturaServlet extends HttpServlet {
    static private final Logger LOGGER = Logger.getLogger("mx.com.pydee.jasperservlet.servlet.FacturaServlet");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            Factura factura = new Factura();
            byte[] salida = factura.generarPdf();

            try (OutputStream outStream = response.getOutputStream()) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename=factura.pdf");
                response.setContentLength(salida.length);

                outStream.write(salida);
                outStream.flush();
            }

        } catch (JRException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }
}
