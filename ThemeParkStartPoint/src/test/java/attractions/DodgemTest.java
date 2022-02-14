package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(4.50, dodgems.defaultPrice(), 0.0);
    }

    @Test
    public void ageUnder12PayHalfPrice() {
        visitor = new Visitor(11, 1.25, 5.00);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.0);
    }

    @Test
    public void age12UpwardsPayDefault() {
        visitor = new Visitor(12, 1.35, 10.00);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.0);
    }
}
