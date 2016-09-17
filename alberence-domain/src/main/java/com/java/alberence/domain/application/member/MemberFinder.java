package com.java.alberence.domain.application.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberFinder {

	@Autowired
	private MemberRepository memberRepository;

	public Member find(Long memberId) {
		return memberRepository.findOne(memberId);
	}

	public Member findByEmail(String email) {
		return memberRepository.findByEmailAndSecessionFalse(email);
	}
}
