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

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void over200TallPeoplePayDouble() {
        visitor = new Visitor(18, 201.00, 25.00);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.0);
    }

    @Test
    public void lessThan200TallPeoplePayDefault() {
        visitor = new Visitor(18, 200.00, 25.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.0);
    }
}
