package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Accounts", description = "Schema to hold Account information")
public class AccountsDTO {

    @Schema(description = "Account number of EasyBank account", example = "1234567891")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    @NotEmpty(message = "Account number cannot be null or empty")
    private Long accountNumber;

    @Schema(description = "Account type of EasyBank account", example = "Savings")
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(description = "EasyBank branch address", example = "\"123 Wall Street, New York\"")
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;
}
