package com.java.alberence.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings({ "PMD.UnusedPrivateField", "findbugs:EQ_DOESNT_OVERRIDE_EQUALS" })
public class AbstractEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id; // NOSONAR
	protected String updatedBy = "system"; // NOSONAR
	@LastModifiedDate
	protected LocalDateTime updatedAt; // NOSONAR
	protected String createdBy = "system"; // NOSONAR
	@CreatedDate
	protected LocalDateTime createdAt; // NOSONAR

	public boolean isNew() {
		return id == null;
	}

	@Override
	public boolean equals(Object obj) {

		if (null == obj) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!getClass().equals(obj.getClass())) {
			return false;
		}

		Persistable that = (Persistable) obj;

		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}
}
