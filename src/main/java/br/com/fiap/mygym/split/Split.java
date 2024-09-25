package br.com.fiap.mygym.split;

import java.time.LocalDateTime;

import br.com.fiap.mygym.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "split")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Split {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //ex push, pull, legs // A,B,C // A,B,C,D // A,B,C,D,E // FullBody // UpperLower // BroSplit // UpperLowerPushPull // PushPullLegs
    private String type;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    User user;
}
