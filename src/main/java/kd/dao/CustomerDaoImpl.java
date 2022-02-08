package kd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kd.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
   @Autowired	
   SessionFactory sf;

@Override
  public boolean save(Customer cx) {
    Session s=sf.openSession();
    s.beginTransaction();
    s.save(cx);
    s.getTransaction().commit();
	return true;
}

@Override
public Customer get(int id) {
	 Session s=sf.openSession();
	 s.beginTransaction();
     Customer c=s.get(Customer.class,id);
     s.getTransaction().commit();
	 return c;
}

@Override
public List<Customer> getAll() {
	 Session s=sf.openSession();
	 s.beginTransaction();
	 Query q=s.createQuery("from Customer");
	 List<Customer> lt=new ArrayList();
	 lt=q.list();
	 s.getTransaction().commit();
	 return lt;
}

@Override
public boolean update(int id, Customer cx) {
	 Session s=sf.openSession();
	 s.beginTransaction();
	 Customer c=s.get(Customer.class,id);
	 System.out.println("Given Data to update:"+cx.getName());
	 if(c!=null)
	 {	 
	   c.setAddress(cx.getAddress());
	   c.setBill(cx.getBill());
	   c.setName(cx.getName());
	   s.update(c);
	   s.getTransaction().commit();
	   return true;
	 }
	 else
		  return false;
      
}

@Override
public boolean delete(int id) {
	Session s=sf.openSession();
	s.beginTransaction();
	 Customer c=s.get(Customer.class,id);
	 if(c!=null)
	 {
	   s.delete(c);
	   s.getTransaction().commit();
	   return true;
	 }
	 else
		 return false;
}
   
   
   
}
