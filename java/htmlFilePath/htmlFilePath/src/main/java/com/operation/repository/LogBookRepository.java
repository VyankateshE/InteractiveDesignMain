package com.operation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operation.Entity.LogData;

@Repository
public interface LogBookRepository extends JpaRepository<LogData, Integer> {
	
	 List<LogData> findBySendRequestTimeBetween(Date startDate, Date endDate);

}
