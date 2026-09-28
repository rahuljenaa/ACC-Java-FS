package com.accenture.ltt.bean;

public class Address {

	private String addressLine1;
	private String addressLine2;

	public Address() {
		System.out.println("From the constructor of Address class\n");
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		System.out.println("From: Setter of Address Line1\n");
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {

		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		System.out.println("From: Setter of Address Line2\n");
		this.addressLine2 = addressLine2;
	}

	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result
				+ ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		return true;
	}
	
	
}
