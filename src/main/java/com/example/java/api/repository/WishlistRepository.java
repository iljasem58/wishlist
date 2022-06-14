package com.example.java.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java.api.model.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>{

}
