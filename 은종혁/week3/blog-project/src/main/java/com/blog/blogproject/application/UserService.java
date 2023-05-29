package com.blog.blogproject.application;

import com.blog.blogproject.domain.User;
import com.blog.blogproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getEntity(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
