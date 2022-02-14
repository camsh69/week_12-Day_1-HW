package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void isAllowedHeight__True() {
        visitor = new Visitor(19, 145.0, 25.00);
        assertTrue(rollerCoaster.isAllowed(visitor));
    }

    @Test
    public void isAllowedHeight__False() {
        visitor = new Visitor(19, 144.9, 25.00);
        assertFalse(rollerCoaster.isAllowed(visitor));
    }
}
