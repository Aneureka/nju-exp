package cn.edu.nju.TrainingCollege.repository;

import cn.edu.nju.TrainingCollege.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hiki on 2018-01-30
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}