/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jacs
 */
public class FiltroAdmin implements Filter {
    
    private FilterConfig configuracion;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuracion = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest) request).getSession().getAttribute(
                UsuarioLoginBean.USER_KEY) == null || !((TipoUsuario)((HttpServletRequest) request).getSession().getAttribute(
                UsuarioLoginBean.USER_KEY)).getRole().equals("administrador") ) {
            ((HttpServletResponse) response).sendRedirect("../index.jspx");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.configuracion = null;
    }
    
}
