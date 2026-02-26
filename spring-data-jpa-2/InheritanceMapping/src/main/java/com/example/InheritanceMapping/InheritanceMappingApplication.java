package com.example.InheritanceMapping;

import com.example.InheritanceMapping.model.CreditCardPayment;
import com.example.InheritanceMapping.model.UPIPayment;
import com.example.InheritanceMapping.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InheritanceMappingApplication implements CommandLineRunner {

	private final PaymentRepository paymentRepository;

	public InheritanceMappingApplication(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(InheritanceMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CreditCardPayment card = new CreditCardPayment();
		card.setAmount(5000);
		card.setPayerName("Aditya");
		card.setCardNumber("1234-5678-9999");
		card.setBankName("HDFC");

		UPIPayment upi = new UPIPayment();
		upi.setAmount(2000);
		upi.setPayerName("Rahul");
		upi.setUpiId("rahul@upi");

		paymentRepository.save(card);
		paymentRepository.save(upi);

		System.out.println("Data inserted successfully!");
	}
}
