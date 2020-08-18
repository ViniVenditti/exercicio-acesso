package br.com.vinicius.access.repository;

import br.com.vinicius.access.entity.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AccessRepository extends JpaRepository<AccessEntity, Long>{

    void removeByDoorIdAndClientId(@Param("doorId") Long doorId, @Param("clientId") Long clientId);
}
