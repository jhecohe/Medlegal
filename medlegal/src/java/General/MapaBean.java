/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Persistencia.Panoramaderiesgos;
import UtilPersistencia.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class MapaBean {

    /**
     * Creates a new instance of MapaBean
     */
    private MindmapNode root;
    private MindmapNode nodoSeleccionado;
    private int idproceso;

    public MapaBean() {
        System.out.println("idproceso  "+idproceso);
        Listados lista = new Listados();
        List riesgos = lista.listaPanoramabyProceso(2);
        root = new DefaultMindmapNode("Proceso22", "Proceso", "FFCC00", false);
        for (int i = 0; i < riesgos.size(); i++) {
            Panoramaderiesgos panora = (Panoramaderiesgos) riesgos.get(i);
            root.addNode(new DefaultMindmapNode(panora.getRiesgoByIdriesgo().getDescripcion(), panora.getRiesgoByIdcausa().getIdriesgo(), "6e9ebf", true));
        }

    }

    public MindmapNode getRoot() {
        return root;
    }

    public void setRoot(MindmapNode root) {
        this.root = root;
    }

    public MindmapNode getNodoSeleccionado() {
        return nodoSeleccionado;
    }

    public void setNodoSeleccionado(MindmapNode nodoSeleccionado) {
        this.nodoSeleccionado = nodoSeleccionado;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }
}
