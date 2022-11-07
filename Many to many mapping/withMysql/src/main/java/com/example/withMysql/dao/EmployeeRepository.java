package com.example.withMysql.dao;

import com.example.withMysql.entities.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

// No need to make service as it is same package inside withMysql
public interface EmployeeRepository extends JpaRepository<Emp,Integer> {
}
