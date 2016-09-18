package com.java.alberence.security;

import com.java.alberence.domain.application.member.Member;
import com.java.alberence.domain.application.member.MemberFinder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberFinder memberFinder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Member member = memberFinder.findByEmail(email);

		final List<Authority> authorities = member.getMemberAuth()
			.stream()
			.map(memberAuth -> new Authority(memberAuth.getRole().getName()))
			.collect(Collectors.toList());

		return new User(member.getEmail(), member.getPassword(), authorities);
	}

	@Getter
	@AllArgsConstructor
	public static class Authority implements GrantedAuthority {
		private String Authority;
	}
}
