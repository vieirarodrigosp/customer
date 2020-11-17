package br.com.vieirabarbosa.customer.business.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vieirabarbosa.customer.DTO.AddressDTO;

@Component
public class AddressBO {
	@Autowired
	private CustomerBO customerBO;
	public Boolean createAddressDTO(int idCustomer, AddressDTO address) {
		return customerBO.customerList.get(idCustomer).addressList.add(address);
	}
	public Object[] getAddressList(int idCustomer){
		return customerBO.customerList.get(idCustomer).addressList.toArray();
	}
	public AddressDTO getAddress(int idCustomer, int idAddress) {
		return customerBO.customerList.get(idCustomer).addressList.get(idAddress);
	}
	public AddressDTO updateAddress(int idCustomer, int idAddress, AddressDTO address) {
		return customerBO.customerList.get(idCustomer).addressList.set(idAddress, address);
	}
	public AddressDTO deleteAddress(int idCustomer, int idAddress) {
		return customerBO.customerList.get(idCustomer).addressList.remove(idAddress);
	}
}