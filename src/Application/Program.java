package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entites.enums.WorkerLevel;
import entities.*;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departament = input.next();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = input.next();
		System.out.print("Level: ");
		String level = input.next();
		System.out.print("Base salary:");
		double baseSal = input.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSal, new Department(departament));

		System.out.print("How many contracts to this worker? ");
		int n = input.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Enter contract #"+ i +"data: ");
			
			System.out.print("Date (DD/MM/YYYY)");
			Date contractDate = sdf.parse(input.next());
			System.out.print("Value per hour:");
			double valuePerHour = input.nextDouble();
			System.out.print("Duration (hours):");
			int hours = input.nextInt();
			HourContract contract = new HourContract(contractDate,valuePerHour,hours);
			worker.addContract(contract);
			
			
		}

			System.out.print("Inform the Year: ");
			int year = input.nextInt();
			System.out.print("inform the Month: ");
			int month = input.nextInt();
			
			System.out.println("Value Reference the Month: " + worker.income(year,month));
		
	}

}
