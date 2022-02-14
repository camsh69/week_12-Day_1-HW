package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void isOfLegalAge__True() {
        visitor = new Visitor(18, 145.5, 20.00);
        assertTrue(tobaccoStall.isAllowed(visitor));
    }

    @Test
    public void isOfLegalAge__False() {
        visitor = new Visitor(17, 145.5, 20.00);
        assertFalse(tobaccoStall.isAllowed(visitor));
    }
}
