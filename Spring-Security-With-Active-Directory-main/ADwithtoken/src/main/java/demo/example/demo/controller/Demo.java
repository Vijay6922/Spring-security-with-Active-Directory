package demo.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    
    // This endpoint returns a welcome message for Imaginnovate.
    @GetMapping("/Imag")
    public String m3() {
        return "welcome to Imaginnovate";
    }
    
    // This endpoint returns a welcome message for Jb hunt.
    // It requires the caller to have the authority '2.0'.
    @GetMapping("/Jb Hunt")
    @PreAuthorize("hasAuthority('2.0')")
    public String m1() {
        return "welcome to Jb hunt";
    }

    // This endpoint returns a welcome message for Logistics.
    // It requires the caller to have the authority 'User'.
    @GetMapping("/Logistics")
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<String> m2() {
        return ResponseEntity.status(HttpStatus.OK).body("welcome to logistics");
    }
}
