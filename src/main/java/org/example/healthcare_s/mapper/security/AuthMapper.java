package org.example.healthcare_s.mapper.security;

import org.example.healthcare_s.dto.userdto.RegisterUser;
import org.example.healthcare_s.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface AuthMapper {
    @Mapping(target="id",ignore = true)
    User toEntity(RegisterUser user);
}
