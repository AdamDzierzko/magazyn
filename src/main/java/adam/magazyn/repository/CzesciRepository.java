package adam.magazyn.repository;

import adam.magazyn.entity.Czesci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CzesciRepository extends JpaRepository<Czesci, Long> {

    @Modifying
    @Query("update Czesci c set c.ilosc = c.ilosc +:zmiana where c.id=:i")
    void zmianaIlosci(@Param("zmiana") int zmiana, @Param("i") Long i);
}
