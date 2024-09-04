package com.kimdabang.kdbserver.Address.infrastructure;

import com.kimdabang.kdbserver.Address.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserUuid(String uuid);
    Optional<Address> findById(Long id);

}
