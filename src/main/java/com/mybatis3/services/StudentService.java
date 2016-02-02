package com.mybatis3.services;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;

/**
 * StudentService
 * Created by noprom on 2/2/16.
 */
public class StudentService implements StudentMapper{

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> findAllStudents() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据学生id查找学生
     * @param studId
     * @return
     */
    public Student findStudentById(Integer studId) {
        logger.debug("Select Student By ID :{}", studId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 插入学生
     * @param student
     */
    public void insertStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
