package com.morningstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;
import com.morningstar.entity.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Integer> {

}
