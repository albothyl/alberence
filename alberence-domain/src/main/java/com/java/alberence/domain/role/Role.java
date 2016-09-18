package com.java.alberence.domain.role;

import com.java.alberence.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Role extends AbstractEntity {
	private String name;
	private boolean used;
	private String description;
}
