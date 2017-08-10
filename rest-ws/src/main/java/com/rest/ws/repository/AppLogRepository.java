package com.rest.ws.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.ws.model.ApplicationLog;

public interface AppLogRepository extends CrudRepository<ApplicationLog, Long> {

}
