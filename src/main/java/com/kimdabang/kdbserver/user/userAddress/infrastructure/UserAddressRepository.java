package com.kimdabang.kdbserver.user.userAddress.infrastructure;

import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
