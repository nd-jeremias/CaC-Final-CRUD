package com.cac.trabajofinal.filters;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método init, puedes dejarlo vacío si no necesitas inicialización específica
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        // Permitir acceso desde cualquier origen
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");

        // Métodos permitidos
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");

        // Cabeceras permitidas
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Preflight (OPTIONS) cache timeout (10 minutes)
        httpResponse.setHeader("Access-Control-Max-Age", "600");

        // Si es una solicitud OPTIONS, simplemente termina la solicitud
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Continúa con el siguiente filtro en la cadena
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        // Método destroy, puedes dejarlo vacío si no necesitas limpieza específica
    }
}
