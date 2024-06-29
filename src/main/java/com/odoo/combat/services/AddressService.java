package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Address;
import com.odoo.combat.entities.Cities;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long addressId);

    Address createAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddress(Long addressId);

    // Additional methods based on your needs (optional)
    List<Address> getAddressesByCity(Cities city);
}
