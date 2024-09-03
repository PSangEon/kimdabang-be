package com.kimdabang.kdbserver.Address.infrastructure;

import com.kimdabang.kdbserver.Address.domain.Address;
import com.kimdabang.kdbserver.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface AddressRepositoryCustom {
    List<Address> getUserAddressWithUser(User user);
    Optional<Address> findByUserAddressIdWithUser(Long id, User user);
}
