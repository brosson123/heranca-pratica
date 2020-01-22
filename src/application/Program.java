package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitis.ImportedProduct;
import entitis.Product;
import entitis.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		List<Product> product = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			System.out.print("Common, used or imported (c/u/i)? ");
			sc.nextLine();
			char type = sc.nextLine().charAt(0);
			System.out.println("Product #" + i + " data:");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(type == 'c') {
			product.add(new Product(name, price));
			}
			if(type == 'u') {
				System.out.print("Manufactured date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, manufactureDate));
			}
			if(type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println("Price Tags: ");
		for(Product list : product) {
			System.out.println(list.priceTag());
		}
		
		sc.close();
	}

}
