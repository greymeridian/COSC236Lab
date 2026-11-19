package lab5.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import lab5.*;

/**
 * COSC236 Lab 05
 * Part 3 (Ronny): Added TestBookDependencyInversion to the JUnit suite.
 */

@Suite
@SelectClasses({TestAddRemoveBooks.class, 
				TestAddRemoveMembers.class,
				TestFindClassString.class,
				TestBorrowBooks.class,
				TestNotAvailableBook.class,
				TestRemoveMemberWithBooks.class,
				TestController.class,
				TestBookDependencyInversion.class})
public class AllTests {
    // No need for test methods here; the suite will run the included classes
}

