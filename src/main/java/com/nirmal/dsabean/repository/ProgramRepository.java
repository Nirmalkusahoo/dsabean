package com.nirmal.dsabean.repository;

import com.nirmal.dsabean.model.ProgramDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramDetail, Long> {
}
