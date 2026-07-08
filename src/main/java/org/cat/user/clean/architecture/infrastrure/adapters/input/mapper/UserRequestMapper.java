package org.cat.user.clean.architecture.infrastrure.adapters.input.mapper;

import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastrure.adapters.input.dto.UserRequest;
import org.mapstruct.factory.Mappers;

public interface UserRequestMapper {

    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    User toUser(UserRequest userRequest);
}
