package bankManagement.service;

import bankManagement.model.Address;
import bankManagement.model.Customer;

public interface AddressService {
    Address getAddressById(long personId);
    void insertPerson(Address address);
}
