package com.brq.ms04.repositories;

import com.brq.ms04.models.ActiveMQModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveMQRespository extends JpaRepository<ActiveMQModel, Integer> {
}
