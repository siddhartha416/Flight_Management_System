package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.repo.PaymentRepo;

@Repository
public class PaymentDao {

	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}
	
	public Payment fetchPaymentById(int paymentId) {
		Optional<Payment> payment=paymentRepo.findById(paymentId);
		if(payment.isPresent()) {
			return payment.get();
		}else {
			return null;
		}
	}
	
	public Payment deletePaymentById(int paymentId) {
		Optional<Payment> payment=paymentRepo.findById(paymentId);
		if(payment.isPresent()) {
			paymentRepo.delete(payment.get());
			return payment.get();
		}else {
			return null;
		}
	}
	
	public Payment updatePaymentById(int oldPaymentId,Payment newPayment) {
		Optional<Payment> payment=paymentRepo.findById(oldPaymentId);
		if(payment.isPresent()) {
			newPayment.setPaymentId(oldPaymentId);
			return savePayment(newPayment);
		}else {
			return null;
		}
	}
	
	public List<Payment> fetchAllPayment(){
		return paymentRepo.findAll();
	}
}
