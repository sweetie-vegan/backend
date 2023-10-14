package com.sweetievegan.subscribe.domain.entity;

import com.sweetievegan.auth.domain.entity.Member;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="subscribes")
public class Subscribe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/* 상품 정보 */
	private int size;
	private int perWeek;
	private double price;
	private String preference;
	private String allergy;

	/* 고객 정보 */
	private String name;
	private String address;
	private String addressDetail;
	private String tel;

	@CreatedDate
	private LocalDateTime createDate;

	@OneToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public void setMember(Member member) {
		this.member = member;
	}
}
