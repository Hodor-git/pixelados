/*
package es.vampitel.arquillian.ejemplo;

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

import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.dao.UsuarioDAO;
import es.vampitel.pixelados.modelo.ejb.ServicioAcreditacion;

@RunWith(Arquillian.class)
public class UsuarioServicioTest {
	
	@Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(Usuario.class.getPackage())
            //.addPackage(ServicioAcreditacion.class.getPackage())
            .addPackage(UsuarioDAO.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	
	@EJB
	ServicioAcreditacion usuarioServicio;
	
	@Inject
	UsuarioDAO usuarioDAO;
	
	/*
	@Test
	public void pruebaAutenticacion() {	
		boolean resultado = usuarioServicio.autentificarUsuario("fulanito", "gafotas");
		Assert.assertEquals(true, resultado);
		System.out.println("Los parametros de autenticacion son correctos");	
	}
	
	
	@Test
	public void comprobarAccesoAdministrador() {
		boolean comprobarAcceso = usuarioServicio.tieneAccesoAdministrador("fulanito");
		Assert.assertEquals(true, comprobarAcceso);
		System.out.println("Tiene acceso de administrador");
	}
	
	/*
	@Test
	public void muestraNombre() {
		String nombre = usuarioServicio.mostrarNombre((long) 52);
		Assert.assertEquals("fulanito", nombre);
		System.out.println("El nombre mostrado es correcto");
	}
	
	
	@Test 
	public void comprobarSiExiste() {
		boolean existe = usuarioServicio.comprobarSiExiste("fulanito");
		Assert.assertEquals(true, existe);
		System.out.println("El nombre existe en la base de datos");
	}
	
	
	@Test
	public void comprobarRetorno() {
		Usuario pepe = usuarioDAO.buscarPorNombre("pepito");
		//Assert.assertEquals("pepito", pepe.getNombre());
		Assert.assertEquals(Usuario.class, pepe.getClass());
		System.out.println("Usuario existe en la BBD");
	}
	
}
	*/