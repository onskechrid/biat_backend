package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"DownloadPin\"", schema = "public")
public class DownloadPin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pin;
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private Boolean isValidated;
}
