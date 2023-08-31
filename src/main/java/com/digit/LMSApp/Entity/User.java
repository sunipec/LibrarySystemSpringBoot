package com.digit.LMSApp.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;

	String uname;

	@ManyToOne(cascade = CascadeType.ALL)
	SubscriptionType subscription;
	@OneToMany(cascade = CascadeType.ALL)
	List<PurchaseBook> purchasedBooks;
	
	@OneToMany(mappedBy="user")
	private List<ReviewBook> reviewBook;
	
      
	
	/**
	 * @param uid
	 * @param uname
	 * @param subscription
	 * @param purchasedBooks
	 */
	public User(int uid, String uname, SubscriptionType subscription, List<PurchaseBook> purchasedBooks) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.subscription = subscription;
		this.purchasedBooks = purchasedBooks;
	}

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public SubscriptionType getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionType subscription) {
		this.subscription = subscription;
	}

	public List<PurchaseBook> getPurchasedBooks() {
		return purchasedBooks;
	}

	public void setPurchasedBooks(List<PurchaseBook> purchasedBooks) {
		this.purchasedBooks = purchasedBooks;
	}

	public List<ReviewBook> getReviewBook() {
		return reviewBook;
	}

	public void setReviewBook(List<ReviewBook> reviewBook) {
		this.reviewBook = reviewBook;
	}

	
}
