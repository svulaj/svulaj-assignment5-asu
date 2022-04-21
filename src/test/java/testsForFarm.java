import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Main;
import main.java.Farm;

public class testsForFarm {

    
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void test() {
        Farm theFarm = new Farm("long horn");
        
        assertNotNull("long horn", theFarm);
    }

}
