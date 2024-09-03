package com.kimdabang.kdbserver.Address.infrastructure;

import com.kimdabang.kdbserver.Address.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserUuid(String uuid);


}
