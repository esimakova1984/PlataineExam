package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UserRegistrationRequired {
    String firstName;
    String lastName;
    String password;
    String confirmPassword;
}
