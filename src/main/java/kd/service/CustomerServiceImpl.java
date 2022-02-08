package kd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kd.dao.CustomerDao;
import kd.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao cd;
	
	@Override
	public boolean save(Customer cx) {
	   return cd.save(cx);
	}

	@Override
	public Customer get(int id) {
		return cd.get(id);
	}

	@Override
	public List<Customer> getAll() {
	   return cd.getAll();
	}

	@Override
	public boolean update(int id, Customer cx) {
       return cd.update(id, cx);
	}

	@Override
	public boolean delete(int id) {
       return cd.delete(id);
	}

}
