package com.nam.migi_service.mapper;
import com.nam.migi_service.dto.request.UserCreationRequest;
import com.nam.migi_service.dto.request.UserUpdateRequest;
import com.nam.migi_service.dto.response.UserResponse;
import com.nam.migi_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);

    @Mapping(source = "firstName",target = "lastName")
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
