/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Control.ValidarLogin;

/**
 *
 * @author usuario
 */
public class JUnitTest {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud de password incorrecta";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        Usuario a = new Usuario();  //Declarar objetos de top Usuario
        Usuario b = new Usuario(); 
        Usuario c = new Usuario(); 
        
        
        a.setNombre("Juan");        //Agregar atributos de a
        a.setPassword("1234");
        b.setNombre("Pedro");
        b.setPassword("123");
        c.setNombre("Maria");
        c.setPassword("12345");
        
        usuarios.add(a);    //Agregar al array List
        usuarios.add(b);
        usuarios.add(c);
        
        
        sistema.setUsuarios(usuarios); //Se le està pasando el arraylist
        
        //System.out.println("-----" + usuarios);
        
        for (Usuario u: sistema.getUsuarios()){ //Lee lo que tenga el arrayList
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("---------");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testLongitudNombre(){
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);   
    }
    
    @Test
    public void testLongitudContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);   
    }
    
    @Test 
    public void testNombre(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
   
    
    @Test
    public void testContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Maria");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
        
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);   
    }
    
    @Test
    public void testDatos(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
           
    }
    
    
    @Test
    public void testTodoCorrecto(){
        Usuario u = new Usuario();
        
        u.setNombre("Juan");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);   
        
        u.setNombre("Pedro");
        u.setPassword("123");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);   
        
        u.setNombre("Maria");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);   
    }
    
    // public void hello() {}
}
