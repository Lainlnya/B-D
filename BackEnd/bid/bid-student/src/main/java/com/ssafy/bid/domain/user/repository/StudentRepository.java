package com.ssafy.bid.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.bid.domain.user.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
