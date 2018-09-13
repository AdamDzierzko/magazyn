package adam.magazyn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Czesci")
public class Czesci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 200)
    @Column(unique = true, nullable = false, length = 200)
    private String nazwa;

    @Digits(integer = 15, fraction = 0)
    @Column(unique = true, nullable = false, length = 50)
    private int ilosc;
}
