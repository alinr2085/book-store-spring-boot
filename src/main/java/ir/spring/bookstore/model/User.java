package ir.spring.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
        private String username;
        private String password;
        @ColumnDefault("true")
        private boolean enabled = true;
}
