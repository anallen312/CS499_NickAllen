package test;

import appointment.Appointment;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    @Test
    void testConstructor() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        Appointment appointment = new Appointment("id1", futureDate, "Description here");

        assertNotNull(appointment);
    }

    @Test
    void testBoundaryValues() {
        // Test for Appointment ID length
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(), "Description"));

        // Test for description length
        assertThrows(IllegalArgumentException.class, () -> new Appointment("id1", new Date(), "a".repeat(51)));

        // Test for past date
        assertThrows(IllegalArgumentException.class, () -> new Appointment("id1", new Date(System.currentTimeMillis() - 1000), "Description"));
    }

    @Test
    void testAppointmentIDBoundary() {
        // Test ID exactly 10 characters long
        assertDoesNotThrow(() -> new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "Description"));

        // Test ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(System.currentTimeMillis() + 1000), "Description"));
    }

    @Test
    void testDescriptionBoundary() {
        // Test description exactly 50 characters long
        assertDoesNotThrow(() -> new Appointment("id1", new Date(System.currentTimeMillis() + 1000), "a".repeat(50)));

        // Test description longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> new Appointment("id1", new Date(System.currentTimeMillis() + 1000), "a".repeat(51)));
    }
}
