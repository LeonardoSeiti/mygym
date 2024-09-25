package br.com.fiap.mygym.split;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String name;
    private String type;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
