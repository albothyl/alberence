package com.java.alberence.domain.member;

import com.java.alberence.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Member extends AbstractEntity {
	private String email;
	private String password;
	private String name;
	private boolean secession;

	@JoinColumn(name = "memberId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<MemberAuth> memberAuth;
}
