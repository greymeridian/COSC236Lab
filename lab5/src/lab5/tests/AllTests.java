package lab5.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * COSC236 Lab 05
 * Part 3 (Ronny): Added TestBookDependencyInversion to the JUnit suite.
 * Part 4 (Theo): No added tests, TestAddRemoveBooks, TestBorrowBooks, and
 * TestController were modified.
 * Part 4 (Mike): Added TestBorrowingService to the JUnit suite.
 */

@Suite
@SelectClasses({ TestAddRemoveBooks.class,
		TestAddRemoveMembers.class,
		TestFindClassString.class,
		TestBorrowBooks.class,
		TestNotAvailableBook.class,
		TestRemoveMemberWithBooks.class,
		TestController.class,
		TestBookDependencyInversion.class,
		TestBorrowingService.class })
public class AllTests {
	// No need for test methods here; the suite will run the included classes
}
