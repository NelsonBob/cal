package fr.esgi.tp11.withdao;

import fr.esgi.tp11.Address;

public class MySQLAddressDAO implements AddressDAO {

    @Override
    public Address findById(int addressId) {
        return null;
    }

    @Override
    public void createAddress(Address address) {
        //Do nothing
    }

    @Override
    public void deleteAddress(int addressId) {
        //Do nothing
    }

    @Override
    public void modifyAddress(int addressId, Address address) {
        //Do nothing
    }
}

