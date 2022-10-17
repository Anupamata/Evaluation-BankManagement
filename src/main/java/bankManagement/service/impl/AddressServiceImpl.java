package bankManagement.service.impl;

import bankManagement.dao.AddressDao;
import bankManagement.model.Address;
import bankManagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;
    @Override
    public Address getAddressById(long personId)  {
        Optional<Address> optionalPersonModel=addressDao.getAddressById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public void insertNewAddress(Address address) {
        addressDao.insertNewAddress(address);
    }

    @Override
    public void deleteById(long id) {
        addressDao.deleteById(id);
    }
}
