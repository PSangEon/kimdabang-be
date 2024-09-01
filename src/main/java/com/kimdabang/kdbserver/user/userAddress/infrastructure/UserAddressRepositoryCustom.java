package com.kimdabang.kdbserver.user.userAddress.infrastructure;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;

import java.util.List;

public interface UserAddressRepositoryCustom {
    List<UserAddress> getUserAddressWithUser(User user);
}
