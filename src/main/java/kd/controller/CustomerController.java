package kd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kd.entity.Customer;
import kd.service.CustomerService;

@RestController
public class CustomerController {
  @Autowired	 
  CustomerService cs;
  
  @PostMapping("/save-customer")
  public ResponseEntity<?> saveCustomer(@RequestBody Customer c)
  {
	boolean b=cs.save(c);
	if(b==true)
	    return ResponseEntity.ok("Record Saved Successfully..");
	else
		return ResponseEntity.ok("Record Not Saved,Please check..");
  }
  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable int id)
  {
	Customer c=cs.get(id);
	return ResponseEntity.ok().body(c);
  }
  
  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getAllCustomer()
  {
	List<Customer> lt=cs.getAll();
	return ResponseEntity.ok().body(lt);
  }
  
  @PutMapping("/customer/{id}")
  public ResponseEntity<?> updateCustomer(@PathVariable int id,@RequestBody Customer c)
  {
	boolean b=cs.update(id, c);
	if(b==true)
	    return ResponseEntity.ok("Record Updated Successfully ");
	else
		return ResponseEntity.ok("Record Doesn't Exist , Please check again");
  }
  
  @DeleteMapping("/customer/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable int id)
  {
	boolean b=cs.delete(id);
	if(b==true)
	    return ResponseEntity.ok("Record deleted Successfully ");
	else
		return ResponseEntity.ok("Record Doesn't Exist , Please check again");
  }
}
