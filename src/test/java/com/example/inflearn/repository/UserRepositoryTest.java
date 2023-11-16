package com.example.inflearn.repository;

import com.example.inflearn.model.UserStatus;
import com.example.inflearn.repository.user.UserEntity;
import com.example.inflearn.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/sql/user-repository-test-data.sql")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByIdAndStatus() {
        // given
        // when
        final Optional<UserEntity> findUser = userRepository.findByIdAndStatus(1L, UserStatus.ACTIVE);

        // then
        assertThat(findUser).isPresent();
    }

    @Test
    void findByIdAndStatus는_데이터가_없으면_Optional_empty를_반환한다() {
        // given
        // when
        final Optional<UserEntity> findUser = userRepository.findByIdAndStatus(1L, UserStatus.PENDING);

        // then
        assertThat(findUser).isNotPresent();
        assertThat(findUser).isEmpty();
    }

    @Test
    void findByEmailAndStatus() {
        // given
        // when
        final Optional<UserEntity> findUser = userRepository.findByEmailAndStatus("shyoon991@gmail.com", UserStatus.ACTIVE);

        // then
        assertThat(findUser).isPresent();
    }

    @Test
    void findByEmailAndStatus는_데이터가_없으면_Optional_empty를_반환한다() {
        // given
        // when
        final Optional<UserEntity> findUser = userRepository.findByEmailAndStatus("shyoon991@gmail.com", UserStatus.PENDING);

        // then
        assertThat(findUser).isNotPresent();
        assertThat(findUser).isEmpty();
    }
}
