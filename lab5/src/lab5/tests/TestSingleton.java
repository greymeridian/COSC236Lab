package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.Member;

/*
 * Part 7 (Liam): Test Singleton functionality
 * and constructor dependency injection.
 */

public class TestSingleton {

    @Test
    void testSingletonInstance() {
        BorrowingService service1 = BorrowingService.getInstance();
        BorrowingService service2 = BorrowingService.getInstance();

        assertSame(service1, service2, "Two Singleton instances detected!");
    }

    @Test
    void testMemberServicesSharing() {
        BorrowingService service = BorrowingService.getInstance();

        Member member1 = new Member("Member 1", service);
        Member member2 = new Member("Member 2", service);

        assertSame(member1.getBorrowingService(), member2.getBorrowingService(),
                "Members have two different borrowing services");
    }
}