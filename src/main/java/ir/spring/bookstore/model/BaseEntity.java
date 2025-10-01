package ir.spring.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @CreationTimestamp
        @Column(updatable = false)
        private LocalDateTime created;
        @UpdateTimestamp
        private LocalDateTime modified;
        private LocalDateTime deleted;
}