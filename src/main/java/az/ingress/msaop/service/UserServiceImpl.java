package az.ingress.msaop.service;

import az.ingress.msaop.dao.entity.User;
import az.ingress.msaop.dao.repository.UserRepository;
import az.ingress.msaop.mapper.UserMapper;
import az.ingress.msaop.model.UserCriteria;
import az.ingress.msaop.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        List<User> users = repository.findAll();
        return mapper.entitiesToDtos(users);
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        return mapper.entityToDto(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        repository.delete(user);
    }

    @Override
    public UserDto update(UserDto dto, Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        User userNew = mapper.updateUser(user, dto);
        return mapper.entityToDto(repository.save(userNew));
    }

    @Override
    public UserDto update(UserCriteria userCriteria) {
        User user = repository.findById(userCriteria.getId()).orElseThrow(() -> new RuntimeException("user was not found"));

        user.setAge(userCriteria.getAge());
        user.setName(userCriteria.getName());

        return mapper.entityToDto(repository.save(user));
    }

}
