package com.pedrogennaro.devsuperiororder.app;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.pedrogennaro.devsuperiororder.entities.Order;
import com.pedrogennaro.devsuperiororder.services.OrderService;
import com.pedrogennaro.devsuperiororder.services.ShippingService;

@SpringBootApplication
@ComponentScan({"com.pedrogennaro.devsuperiororder"})
public class DevsuperiorOrderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DevsuperiorOrderApplication.class, args);
	}
	
	@Autowired
	OrderService orderService;
	
	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados de entrada");
		Order order = new Order();
		System.out.println("Código: ");
		order.setCode(sc.nextInt());
		System.out.println("Valor básico: ");
		order.setBasic(sc.nextDouble());
		System.out.println("Porcentagem de desconto: ");
		order.setDiscount(sc.nextDouble());

		System.out.println("Dados de saída");
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n ", orderService.total(order));
	}

}
