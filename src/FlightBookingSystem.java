
System.out.println("Flight Durimport java.time.*;
import java.time.temporal.ChronoUnit;

public class FlightBookingSystem {

    public static void main(String[] args) {
        // TODO 1: Flight Booking Date (LocalDate)
        LocalDate bookingDate = LocalDate.now();  // Initialize booking date (today)
        LocalDate flightDate = LocalDate.of(2024, 12, 15);   // Set a future flight date
        long daysUntilFlight = ChronoUnit.DAYS.between(bookingDate, flightDate);   // Calculate days between booking and flight

        System.out.println("Booking Date: " + bookingDate);
        System.out.println("Flight Date: " + flightDate);
        System.out.println("Days Until Flight: " + daysUntilFlight);

        // TODO 2: Flight Time (LocalTime)
        LocalTime departureTime = LocalTime.of(14, 30);  // Flight departure time
        Duration flightDuration = Duration.ofHours(5).plusMinutes(45);  // Flight duration of 5 hours 45 minutes
        LocalTime arrivalTime = departureTime.plus(flightDuration);  // Calculate arrival time

        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time (after 5 hours 45 minutes): " + arrivalTime);

        // TODO 3: Full Flight Schedule (LocalDateTime)
        LocalDateTime departureDateTime = LocalDateTime.of(flightDate, departureTime); // Combine flight date and time
        LocalDateTime arrivalDateTime = departureDateTime.plus(flightDuration);  // Calculate arrival date and time

        System.out.println("Flight Departure: " + departureDateTime);
        System.out.println("Flight Arrival: " + arrivalDateTime);

        // TODO 4: Instant for Exact Flight Event
        Instant takeoffInstant = Instant.now();  // Exact takeoff moment in UTC
        Instant updatedTakeoffInstant = takeoffInstant.plus(Duration.ofMinutes(10));  // Simulate a 10-minute delay

        System.out.println("Takeoff Time (UTC): " + takeoffInstant);
        System.out.println("Updated Takeoff Time (after 10-minute delay): " + updatedTakeoffInstant);

        // TODO 5: Flight Layover Period (Period)
        Period layoverPeriod = Period.ofDays(1);  // 1-day layover period
        LocalDateTime nextFlightDeparture = arrivalDateTime.plus(layoverPeriod);  // Calculate next flight departure time

        System.out.println("Layover Period: " + layoverPeriod);
        System.out.println("Next Flight Departure: " + nextFlightDeparture);

        // TODO 6: Flight Duration (Duration)
        Duration totalFlightDuration = Duration.ofHours(8);  // Total flight time of 8 hours
        Duration totalTravelTime = totalFlightDuration.plus(layoverPeriod);  // Total travel time with layover

        ation: " + totalFlightDuration);
        System.out.println("Total Travel Time (including layover): " + totalTravelTime);

        // TODO 7: Time Zones for International Flights (ZonedDateTime)
        ZoneId departureZone = ZoneId.of("America/New_York");  // Departure airport time zone
        ZoneId arrivalZone = ZoneId.of("Europe/Paris");  // Destination airport time zone
        ZonedDateTime zonedDepartureTime = ZonedDateTime.of(departureDateTime, departureZone);  // ZonedDateTime for departure
        ZonedDateTime zonedArrivalTime = zonedDepartureTime.plus(flightDuration).withZoneSameInstant(arrivalZone);  // Adjusted ZonedDateTime for arrival

        System.out.println("Departure Time (New York): " + zonedDepartureTime);
        System.out.println("Arrival Time (Paris): " + zonedArrivalTime);

        // TODO 8: Time Between Flights (ChronoUnit.between)
        long hoursBetweenFlights = ChronoUnit.HOURS.between(arrivalDateTime, nextFlightDeparture);  // Calculate hours between flights

        System.out.println("Time Between Flights: " + hoursBetweenFlights + " hours");
    }
}
