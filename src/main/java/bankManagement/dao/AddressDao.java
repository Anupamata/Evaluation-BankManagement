package bankManagement.dao;

import bankManagement.model.Address;
import bankManagement.model.Customer;

import java.util.Optional;

public interface AddressDao {
    Optional<Address> getAddressById(long id);
    void insertPerson(Address address);
}
