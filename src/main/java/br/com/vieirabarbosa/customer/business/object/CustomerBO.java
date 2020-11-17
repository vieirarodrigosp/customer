package br.com.vieirabarbosa.customer.business.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vieirabarbosa.customer.DTO.CustomerDTO;

@Component
public class CustomerBO {
	public List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
	public Boolean createCustomerDTO(CustomerDTO customer) {
		return customerList.add(customer);
	}
	public Object[] getCustomers(){
		return customerList.toArray();
	}
	public CustomerDTO getCustomer(int idCustomer){
		return customerList.get(idCustomer);
	}
	public CustomerDTO updateCustomer( int idCustomer, CustomerDTO customer) {
		return customerList.set(idCustomer, customer);
	}
	public CustomerDTO deleteCustomer(int idCustomer) {
		return customerList.remove(idCustomer);
	}
}