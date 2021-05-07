package org.acm.demo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends PanacheEntityBase {

	@Id
	@SequenceGenerator(
			name = "userSequence",
			sequenceName = "user_id_seq",
			allocationSize = 1,
			initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	private Long id;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Friend> friends;

	private String name;

	private String age;

	private String phone;

	private String description;

	private Boolean isDeleted;

	private Long createStamp;

	private Long updateStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
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
