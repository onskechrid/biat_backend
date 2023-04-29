package tn.biat.biat.security;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCred {
    private String email;
    private String password;
}