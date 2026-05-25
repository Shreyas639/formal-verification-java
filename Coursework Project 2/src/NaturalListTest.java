import static org.junit.Assert.*;

import org.junit.Test;

import com.google.java.contract.PreconditionError;


public class NaturalListTest {

	@Test
	public void testPushInValid() {
		NaturalList list = new NaturalList();
		assertThrows(PreconditionError.class, () -> list.push(null));
	}
	@Test
	public void testPushValid() {
		NaturalList list = new NaturalList();
		Natural n = new Natural(10);
		list.push(n);
		assertEquals(n, list.get(0));
	}
	@Test
	public void testGetInValid() {
		NaturalList list = new NaturalList();
		assertThrows(PreconditionError.class, () -> list.get(0));
	}
	@Test
	public void testGetValid() {
		NaturalList list = new NaturalList();
		Natural n = new Natural(10);
		list.push(n);
		assertEquals(n, list.get(0));

	}
	@Test
	public void testSetInvalid() {
		NaturalList list = new NaturalList();
		assertThrows(PreconditionError.class, () -> list.set(0, new Natural(10)));
		assertThrows(PreconditionError.class, () -> list.set(0, null));
	}
	@Test
	public void testSetValid() {
		NaturalList list = new NaturalList();
		Natural n = new Natural(5);
		Natural m = new Natural(10);
		list.push(n);
		list.set(0, m);
		assertEquals(m, list.get(0));
	}
@Test
public void testSort() {
	NaturalList list = new NaturalList();
	list.push(new Natural(5));
	list.push(new Natural(10));
	list.push(new Natural(1));
	list.sort();
	assertEquals(new Natural(1), list.get(0));
	assertEquals(new Natural(5), list.get(1));
	assertEquals(new Natural(10), list.get(2));
}
@Test
public void testSearchInValid() {
	NaturalList list = new NaturalList();
	assertThrows(PreconditionError.class, () -> list.search(null));
}
@Test
public void testSearchValid() {
	NaturalList list = new NaturalList();
	list.push(new Natural(1));
	list.push(new Natural(4));
	list.push(new Natural(7));
	list.sort();
	assertEquals(1, list.search(new Natural(4)));
	assertEquals(-3, list.search(new Natural(6)));
}
	
}
