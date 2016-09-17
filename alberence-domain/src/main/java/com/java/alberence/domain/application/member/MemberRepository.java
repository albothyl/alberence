package com.java.alberence.domain.application.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByEmailAndSecessionFalse(String email);
}
