package com.github.dlozanoc.festapivity.application.festivities;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.dlozanoc.festapivity.persistence.FestivityEntity;

@Repository
public interface FestivityRepository extends CrudRepository<FestivityEntity, Long>, JpaSpecificationExecutor<FestivityEntity> {

}