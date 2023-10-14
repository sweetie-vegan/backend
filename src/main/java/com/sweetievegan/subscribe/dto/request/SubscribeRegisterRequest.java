package com.sweetievegan.subscribe.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscribeRegisterRequest {
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
}
