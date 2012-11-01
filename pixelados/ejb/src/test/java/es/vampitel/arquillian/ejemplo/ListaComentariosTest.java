/*
import org.jboss.shrinkwrap.api.asset.EmptyAsset;

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
import org.junit.Test;
import org.junit.runner.RunWith;

import es.vampitel.pixelados.modelo.Comentario;
import es.vampitel.pixelados.modelo.dao.ComentarioDAO;
import es.vampitel.pixelados.modelo.ejb.ServicioComentario;

@RunWith(Arquillian.class)
public class ListaComentariosTest {
	
	@Deployment
	public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addPackage(Comentario.class.getPackage())
            .addPackage(ServicioComentario.class.getPackage())
            .addPackage(ComentarioDAO.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@EJB
	ServicioComentario comentarioServicio;
	
	@Test
	public void pruebaAutenticacion() {	
		List<Comentario> resultado = comentarioServicio.listaComentarios((long)54, "analisis");
		Assert.assertEquals(1, resultado.size());
		System.out.println("El número de elementos de la lista es correcto");	
	}

}
*/


