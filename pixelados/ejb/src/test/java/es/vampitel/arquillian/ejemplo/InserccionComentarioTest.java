/*
package es.vampitel.arquillian.ejemplo;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.vampitel.pixelados.modelo.Comentario;
import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.dao.ComentarioDAO;
import es.vampitel.pixelados.modelo.dao.SeccionWebDAO;
import es.vampitel.pixelados.modelo.dao.UsuarioDAO;
import es.vampitel.pixelados.modelo.ejb.ServicioComentario;

@RunWith(Arquillian.class)
public class InserccionComentarioTest {
	
	@Deployment
	public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addPackage(Usuario.class.getPackage())
        	.addPackage(UsuarioDAO.class.getPackage())
        	.addPackage(Comentario.class.getPackage())
            .addPackage(ServicioComentario.class.getPackage())
            .addPackage(ComentarioDAO.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@EJB
	ServicioComentario comentarioServicio;
	
	@Inject
	SeccionWebDAO seccionWebDAO;
	
	@Inject
	UsuarioDAO usuarioDAO;
	
	
	@Before
	public void preparePersistenceTest() throws Exception { 
	    insertaDatos();
	}
	
	public void insertaDatos() {
		String comentario = "probando probando, con el mazo dando";
		Usuario pepe = usuarioDAO.buscarPorNombre("pepito");
		
		comentarioServicio.insertaComentario(comentario, pepe, 54, "analisis");
	}
	
	@Test
	public void pruebaAutenticacion() {	
		List<Comentario> resultado = comentarioServicio.listaComentarios((long)54, "analisis");
		Assert.assertEquals(2, resultado.size());
		System.out.println("El número de elementos de la lista es correcto");	
	}
	

}
*/

