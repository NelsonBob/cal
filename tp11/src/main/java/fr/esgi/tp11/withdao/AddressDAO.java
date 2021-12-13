package fr.esgi.tp11.withdao;

import fr.esgi.tp11.Address;

public interface AddressDAO {

    Address findById(int addressId);

    void createAddress(Address address);

    void deleteAddress(int addressId);

    void modifyAddress(int addressId, Address address);
}
