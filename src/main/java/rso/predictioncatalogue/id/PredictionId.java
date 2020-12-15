package rso.predictioncatalogue.id;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PredictionId implements Serializable
{
    private Long predictionId;
    private int team;
}
