package actions.controller;

import actions.dto.StudentDto;
import actions.entity.Student;
import actions.mapper.StudentMapper;
import actions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // R: 모든 이름 조회
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents().stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    // R: ID로 이름 조회
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id)
                .map(StudentMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // C: 새로운 학생 추가
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        Student student = StudentMapper.fromDTO(studentDto);
        return StudentMapper.toDTO(studentService.createStudent(student));
    }

    // U: ID로 학생 이름 변경
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id, studentDto.getName())
                .map(StudentMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // D: ID로 학생 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}