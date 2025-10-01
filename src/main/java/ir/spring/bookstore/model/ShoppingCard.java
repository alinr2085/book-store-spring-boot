package ir.spring.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCard extends BaseEntity {
        private int count;
        @ManyToOne
        @JoinColumn(name = "factor_id")
        private Factor factor;
        @ManyToOne
        @JoinColumn(name = "book_id")
        private Book book;
}

