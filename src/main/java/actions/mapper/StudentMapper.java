package actions.mapper;

import actions.entity.Student;
import actions.dto.StudentDto;


public class StudentMapper {
    // Entity -> DTO
    public static StudentDto toDTO(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .build();
    }

    // DTO -> Entity
    public static Student fromDTO(StudentDto dto) {
        return Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
