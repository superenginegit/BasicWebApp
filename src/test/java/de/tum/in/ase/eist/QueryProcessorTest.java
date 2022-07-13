package de.tum.in.ase.eist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}
	
	@Test
	void testWhatIsYourName() {
		String actualString = queryProcessor.process("what is your name");
		assertEquals("Simon", actualString);
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}
	
	@Test
	void testPlus() {
		String actualString = queryProcessor.process("3 plus 7");
		assertEquals("10", actualString);
	}
	
	@Test
	void testMul() {
		String actualString = queryProcessor.process("3 multiplied by 7");
		assertEquals("21", actualString);
	}
	
	@Test
	void testLargest() {
		String actualString = queryProcessor.process("is the largest: 10,3,5,8,1,9,5");
		assertEquals("10", actualString);
	}
}
