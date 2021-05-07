package org.acm.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Friend extends PanacheEntity {

	@SequenceGenerator(
			name = "friendSequence",
			sequenceName = "friend_id_seq",
			allocationSize = 1,
			initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendSequence")
	private Long id;

	@ManyToOne
	@JsonIgnore
	private User user;

	private Long friend;

	private Boolean isDeleted;

	private Long createStamp;

	private Long updateStamp;

	public static List<Friend> findByUserId(Long userId) {
		return find ("useId", userId).list ();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getFriend() {
		return friend;
	}

	public void setFriend(Long friend) {
		this.friend = friend;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}

	public Long getCreateStamp() {
		return createStamp;
	}

	public void setCreateStamp(Long createStamp) {
		this.createStamp = createStamp;
	}

	public Long getUpdateStamp() {
		return updateStamp;
	}

	public void setUpdateStamp(Long updateStamp) {
		this.updateStamp = updateStamp;
	}
}
