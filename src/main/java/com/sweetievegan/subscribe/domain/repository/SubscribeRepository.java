package com.sweetievegan.subscribe.domain.repository;

import com.sweetievegan.subscribe.domain.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
	Subscribe findSubscribeById(Long id);
}
