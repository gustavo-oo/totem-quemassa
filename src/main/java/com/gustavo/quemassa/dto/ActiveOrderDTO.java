package com.gustavo.quemassa.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ActiveOrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String clienteName;
	private Date endTime;
	private Double totalPrice;
	
	public ActiveOrderDTO() {
	}

	public ActiveOrderDTO(Integer id, String clienteName, Date endTime) {
		super();
		this.id = id;
		this.clienteName = clienteName;
		this.endTime = endTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClienteName() {
		return clienteName;
	}

	public void setClienteName(String clienteName) {
		this.clienteName = clienteName;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActiveOrderDTO other = (ActiveOrderDTO) obj;
		return Objects.equals(id, other.id);
	}
}
