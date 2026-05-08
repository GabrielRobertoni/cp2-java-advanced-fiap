package br.com.fiap.cp2.repository;

import br.com.fiap.cp2.entity.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}
