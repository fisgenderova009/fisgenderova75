package az.developia.booksale.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private Double totalPrice;

private LocalDateTime registerDate;

private Integer sellerId;
private Integer customerId;
}
