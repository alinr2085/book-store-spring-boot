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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Factor extends BaseEntity {
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
        private boolean payed;
}
