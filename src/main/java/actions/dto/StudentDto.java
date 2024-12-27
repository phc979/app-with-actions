package actions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link actions.entity.Student}
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    Integer id;
    String name;
}