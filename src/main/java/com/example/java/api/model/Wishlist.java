package com.example.java.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "wishlist_name")
    private String wishlistName;

    @Column(name = "wishlist_rate")
    private Integer wishlistRate;

    public Wishlist() {

    }

    public Wishlist(String wishlistName, Integer wishlistRate) {
        super();
        this.wishlistName = wishlistName;
        this.wishlistRate = wishlistRate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getWishlistName() {
        return wishlistName;
    }
    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
    public Integer getWishlistRate() {
        return wishlistRate;
    }
    public void setWishlistRate(Integer wishlistRate) {
        this.wishlistRate = wishlistRate;
    }
}
