package com.java.alberence.domain.application.member;

import com.java.alberence.domain.AbstractEntity;
import com.java.alberence.domain.application.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "memberAuth")
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class MemberAuth extends AbstractEntity {
	@JoinColumn(name = "roleId")
	@OneToOne(fetch = EAGER)
	private Role role;
}
