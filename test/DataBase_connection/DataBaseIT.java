/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase_connection;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohamed
 */
public class DataBaseIT {
    
    public DataBaseIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of main method, of class DataBase.
     */
   

    
    @Test
    public void testGetconnection() throws Exception {
         new DataBase();
       Connection conn= DataBase.getconnection();
        assertEquals(conn !=null, true); 
    }

    
    @Test
    public void testDisconnect() {
        DataBase con =new DataBase();
     assertEquals(con !=null, true);
    }
    
}
