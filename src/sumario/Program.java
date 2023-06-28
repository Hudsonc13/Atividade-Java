package sumario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Client Data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth Date: ");
		Date birthdate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthdate);
		
		System.out.println("Enter Order Data:");
		System.out.print("Status:");
		String status = sc.next();
		
		Order order = new Order(client, OrderStatus.valueOf(status), new Date());
		
		System.out.print("How many itens to this order? ");
		int a = sc.nextInt();
		

		for (int i=1; i<=a; i++) {
			System.out.print("Enter #" + i + " item data:\n");
			sc.nextLine();
			System.out.print("Product Name: ");
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			Double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			
			OrderItem od = new OrderItem(productQuantity, productPrice, product);
			order.addOrderItem(od);
		}
		
		System.out.println();
		System.out.println("Order Sumary:");
		System.out.println(order);
		
		
		sc.close();
	}
	
}
