package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int number = Integer.parseInt(sc.nextLine());
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation res = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + res);

			System.out.println("\nEnter data to update th reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			res.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + res);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		sc.close();
	}
}
