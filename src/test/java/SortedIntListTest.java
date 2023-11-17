import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class SortedIntListTest {
	@Test
	public void testAdd() {
		SortedIntList list = new SortedIntList();
		list.add(1);
		list.add(2);
		list.add(2);
		assertEquals(3, list.size());
	}

	@Test
	public void testAddIndexed() {
		SortedIntList list = new SortedIntList();
		list.add(1);
		list.add(2);
		try {
			list.add(1, 3);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}
	}

	@Test
	public void testUnique() throws NoSuchFieldException, IllegalAccessException {
		SortedIntList list = new SortedIntList(true);
		Field field = list.getClass().getDeclaredField("unique");
		field.setAccessible(true);
        assertEquals(true, field.get(list));
	}

	@Test
	public void testIndexOf() {
		SortedIntList list = new SortedIntList();
		int[] arr = {-4, 2, 7, 10, 15, 20, 22, 25, 30, 36, 42, 50, 56, 68, 85,
				92, 103};
        for (int j : arr) {
            list.add(j);
        }
		assertEquals(10, list.indexOf(42));
	}

	@Test
	public void testMax() {
		SortedIntList list = new SortedIntList();
		list.add(5);
		list.add(10);
		list.add(4);
		assertEquals(10, list.max());
	}

	@Test
	public void testMin() {
		SortedIntList list = new SortedIntList();
		list.add(5);
		list.add(10);
		list.add(4);
		assertEquals(4, list.min());
	}

	@Test
	public void testSetUnique() {
		SortedIntList list = new SortedIntList();
		list.add(5);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(4);
		list.add(4);
		System.out.println("former size" + list.size());
		list.setUnique(true);
		System.out.println("post size" + list.size());
		System.out.println(list);
		assertEquals(3, list.size());
	}

	@Test
	public void testToString() {
		SortedIntList list = new SortedIntList();
		list.add(1);
		list.add(2);
		assertEquals("S:[1, 2]U", list.toString());
	}

}
