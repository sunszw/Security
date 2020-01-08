package com.security.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 617538505522758833L;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer id;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String username;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String password;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer gender;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String creDate;

}
