package test;

import appointment.Appointment;
import appointment.AppointmentService;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        Appointment appointment = new Appointment("id1", futureDate, "Description here");

        service.addAppointment(appointment);

        assertNotNull(service);
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        Appointment appointment = new Appointment("id2", futureDate, "Another description");

        service.addAppointment(appointment);
        service.deleteAppointment("id2");

        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("id2"));
    }

    @Test
    void testBoundaryValues() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        Appointment appointment1 = new Appointment("id1", futureDate, "Description here");
        Appointment appointment2 = new Appointment("id1", futureDate, "Another description");

        // Add one appointment
        service.addAppointment(appointment1);

        // Try adding another appointment with duplicate ID
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));

        // Try deleting an appointment that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("id3"));   
    }
    
    @Test
    void testUniqueAppointmentID() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        Appointment appointment1 = new Appointment("id1", futureDate, "Description here");
        Appointment appointment2 = new Appointment("id1", futureDate, "Another description");

        // Add one appointment
        service.addAppointment(appointment1);

        // Try adding another appointment with duplicate ID
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }

}
