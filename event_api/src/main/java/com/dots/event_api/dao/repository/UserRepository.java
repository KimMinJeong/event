package com.dots.event_api.dao.repository;

import com.dots.event_api.dao.domain.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TbUser, Long> {

    public Optional<TbUser> findByUserSn(Long userSn);
}
