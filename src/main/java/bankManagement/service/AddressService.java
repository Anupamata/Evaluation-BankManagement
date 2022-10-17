package bankManagement.service;

import bankManagement.model.Address;

public interface AddressService {
    Address getAddressById(long personId);
    void insertNewAddress(Address address);
    void deleteById(long id);
}
