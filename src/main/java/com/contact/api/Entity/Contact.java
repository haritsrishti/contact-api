package com.contact.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    public UUID id;

    public String name;

    public String phone;

    public String email;
}
