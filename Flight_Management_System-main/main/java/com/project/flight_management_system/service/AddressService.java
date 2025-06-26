
package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AddressDao;
import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.exception.AddressIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class AddressService {

	@Autowired
	AddressDao addressdao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	@Autowired
	ResponseStructureAll<Address> responseStructureAll;

	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setMessage("Successfully Address Saved In DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressdao.saveAddress(address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int addressId) {
		Address address = addressdao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Successfully Address Fetched From DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressdao.fetchAddressById(addressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Address> deleteAddressById(int addressId) {
		Address address = addressdao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Successfully Address Deleted From DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressdao.deleteAddressById(addressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressdao.fetchAddressById(oldAddressId);
		if (address != null) {
			responseStructure.setMessage("Successfully Address Update In DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressdao.updateAddressById(oldAddressId, newAddress));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructureAll<Address> fetchAllAddress() {
		responseStructureAll.setMessage("Successfully All Address Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(addressdao.fetchAllAddress());
		return responseStructureAll;
	}
}
