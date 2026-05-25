import static org.junit.Assert.*;

import org.junit.Test;

import com.google.java.contract.PreconditionError;


public class NaturalTest {

	@Test
	public void testConstructorInvalid() {
	     assertThrows(PreconditionError.class, () -> new Natural(-1));	//negative inputs
	}
	@Test
    public void testConstructorValid() {
		Natural n = new Natural(5);
		assertEquals(0, n.compareTo(new Natural (5))); //Verify correct
	}
    
	//Increment
	@Test
	public void testIncrementValid () {
		Natural n = new Natural (5);
		n.increment();
		assertEquals (0, n.compareTo(new Natural(6)));
	}
	@Test
	public void testIncrementOverflow () {
		Natural n = new Natural (Integer.MAX_VALUE);
		assertThrows(PreconditionError.class, n::increment);
	}
	//Decrement
	@Test
	public void testDecrementUnderflow () {
		Natural n = new Natural (0);
		assertThrows (PreconditionError.class, n::decrement);
	}
	@Test
    public void testDecrementValid() {
		Natural n = new Natural(10);
		n.decrement();
		assertEquals(0, n.compareTo(new Natural (9)));
		}
	//Test Add
	@Test
	public void testAddValid() {
	Natural n = new Natural(11);
	Natural m = new Natural(5);
    n.add(m);
	assertEquals(0, n.compareTo(new Natural(16)));
	}
	@Test
	public void testAddOverflow() {
	Natural n = new Natural(Integer.MAX_VALUE - 1);
	Natural m = new Natural(2);
	assertThrows (PreconditionError.class, () -> n.add(m));
	}
   //Test Subtract
	@Test
	public void testSubtractValid() {
	Natural n = new Natural(10);
	Natural m = new Natural(5);
	n.subtract(m);
	assertEquals(0, n.compareTo(new Natural(5)));
	}
	@Test
	public void testSubtractUnderflow() {
	Natural n = new Natural(5);
	Natural m = new Natural(10);
	assertThrows (PreconditionError.class, () -> n.subtract(m));
	}
	//Test Multiply
	@Test
	public void testMultiplyValid() {
	Natural n = new Natural(5);
	Natural m = new Natural(3);
	n.multiply(m);
	assertEquals(0, n.compareTo(new Natural(15)));
	}
	@Test
	public void testMultiplyOverflow() {
	Natural n = new Natural(Integer.MAX_VALUE / 2 + 1);
	Natural m = new Natural(2);
	assertThrows (PreconditionError.class, () -> n.multiply(m));
	}
	@Test 
	public void testMultiplyNull() {
		Natural n = new Natural (5);
		assertThrows (PreconditionError.class, () -> n.multiply(null));
	    
	}
	//Test Divide
	@Test
	public void testDivideValid() {
	Natural n = new Natural(10);
	Natural m = new Natural(2);
	n.divide(m);
	assertEquals(0, n.compareTo(new Natural(5)));
	}
	@Test
	public void testDivideByZero() {
	Natural n = new Natural(10);
	Natural m = new Natural(0);
	assertThrows (PreconditionError.class, () -> n.divide(m));
	}
	@Test 
	public void testDivideNull() {
		Natural n = new Natural (5);
		assertThrows (PreconditionError.class, () -> n.divide(null));
	    
	}
	//Test Equality
	@Test
	public void testEquals() {
	Natural n = new Natural(10);
	Natural m = new Natural(10);
	assertTrue (n.equals(m));
	}
	@Test
	public void testNotEquals() {
	Natural n = new Natural(10);
	Natural m = new Natural(5);
	assertFalse (n.equals(m));
	}
	//Test ToString
	@Test
	public void testToString() {
	Natural n = new Natural(10);
	assertEquals("10", n.toString());
	}
	}



