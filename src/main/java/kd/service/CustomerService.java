package kd.service;

import java.util.List;

import kd.entity.Customer;

public interface CustomerService {
	 public boolean save(Customer cx);
	  public Customer get(int id);
	  public List<Customer> getAll();
	  public boolean update(int id,Customer cx);
	  public boolean delete(int id);
}
