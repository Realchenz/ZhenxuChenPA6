import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;


public class ArrayIntListTest {
	@Test
	public void testAdd() {
		//implement me
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(3, list.size());
	}

	@Test
	public void testGet() {
		ArrayIntList list = new ArrayIntList();
		list.add(2);
		list.add(1);
		assertEquals(2, list.get(0));
	}

	@Test
	public void testIndexOf() {
		ArrayIntList list = new ArrayIntList();
		list.add(2);
		list.add(1);
		assertEquals(1, list.indexOf(1));
	}

	@Test
	public void testRemove() {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
		list.remove(0);
		list.remove(0);
		assertEquals(0, list.size());
	}

	@Test
	public void testSize() {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
		assertEquals(2, list.size());
	}

	@Test
	public void testToString() {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		assertEquals("[2, 3]", list.toString());
	}

	@Test
	public void testClear() {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testContains() {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
        assertTrue(list.contains(2));
	}

    @Test
	public void testIsEmpty() {
		ArrayIntList list = new ArrayIntList();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testCheckIndex() throws NoSuchMethodException {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(2);
		list.add(3);
		Class<?> listClass = list.getClass();
		Method checkIndexMethod = listClass.getDeclaredMethod("checkIndex", int.class, int.class);
		checkIndexMethod.setAccessible(true);
		try {
			checkIndexMethod.invoke(list, 3, 2);
            fail();
		} catch (Exception e) {
			assertTrue(e.getCause() instanceof IndexOutOfBoundsException);
		}
	}
}
