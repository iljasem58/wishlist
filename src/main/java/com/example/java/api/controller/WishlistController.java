package com.example.java.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.api.exception.ResourceNotFoundException;
import com.example.java.api.model.Wishlist;
import com.example.java.api.repository.WishlistRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;

    // create wish
    @PostMapping("/wishlist")
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    // get wish by id
    @GetMapping("/wishlist/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
        Wishlist wishlist = wishlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish not exist with id :" + id));
        return ResponseEntity.ok(wishlist);
    }

    // update wish
    @PutMapping("/wishlist/{id}")
    public ResponseEntity<Wishlist> updateEmployee(@PathVariable Long id, @RequestBody Wishlist wishlistDetails){
        Wishlist wishlist = wishlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish not exist with id :" + id));

        wishlist.setWishlistName(wishlistDetails.getWishlistName());
        wishlist.setWishlistRate(wishlistDetails.getWishlistRate());

        Wishlist updatedWishlist = wishlistRepository.save(wishlist);
        return ResponseEntity.ok(updatedWishlist);
    }

    // delete wish
    @DeleteMapping("/wishlist/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWishlist(@PathVariable Long id){
        Wishlist wishlist = wishlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish not exist with id :" + id));

        wishlistRepository.delete(wishlist);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // get all wishes
    @GetMapping("/wishlist")
    public List<Wishlist> getAllWishlists(){
        return wishlistRepository.findAll();
    }
}
