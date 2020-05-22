package org.artrun.web.repositories;

import org.artrun.web.domain.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long>{

}