package dev.maneesha.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Session extends BaseModel {
    private String token;
    private Date expiringAt;
    @ManyToOne
    private User user;
    //it will save the enum type in integer value
    //this can cause issue if:-
    //diff environment has diff config , more specific diff db(indexing will be diff)
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
