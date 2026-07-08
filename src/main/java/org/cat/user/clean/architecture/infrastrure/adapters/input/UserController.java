package org.cat.user.clean.architecture.infrastrure.adapters.input;

import org.cat.user.clean.architecture.application.ports.input.IUserUseCase;
import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastrure.adapters.input.dto.UserRequest;
import org.cat.user.clean.architecture.infrastrure.adapters.input.dto.UserResponse;
import org.cat.user.clean.architecture.infrastrure.adapters.input.mapper.UserRequestMapper;
import org.cat.user.clean.architecture.infrastrure.adapters.input.mapper.UserResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final IUserUseCase userUseCase;

    public UserController(IUserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create (@RequestBody UserRequest userRequest) {

        User user = userUseCase.create(
                UserRequestMapper.INSTANCE.toUser(request)
        );
        return new ResponseEntity<>(
                UserResponseMapper.INSTANCE.toUserResponse(user),
                HttpStatus.CREATED);
    }

}
