package com.ab.cryptoportfolio.entity;

import javax.validation.constraints.Email;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@RequiredArgsConstructor
@Getter
@ToString
public class CryptoUser {

	@Id
	private String id;
	@NonNull
	private final String username;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@Email
	@NonNull
	private String email;
	@NonNull
	private String password;
	@Setter
	private boolean verified;
	@NonNull
	private String securityPin;
	@NonNull
	@Setter
	private boolean totpEnabled;
}
