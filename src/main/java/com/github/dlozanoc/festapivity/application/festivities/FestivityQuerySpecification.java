package com.github.dlozanoc.festapivity.application.festivities;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.github.dlozanoc.festapivity.persistence.FestivityEntity;
import com.github.dlozanoc.festapivity.persistence.FestivityEntityMetamodel;

public class FestivityQuerySpecification {

	public static Specification<FestivityEntity> withFilters(
			String name, ZonedDateTime startDate,
			ZonedDateTime endDate, String place) {

		return new Specification<FestivityEntity>() {

			@Override
			public Predicate toPredicate(Root<FestivityEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if(!StringUtils.isEmpty(name)) {
					predicates.add(cb.and(cb.equal(root.get(FestivityEntityMetamodel.name), name)));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
		};
	}
}
