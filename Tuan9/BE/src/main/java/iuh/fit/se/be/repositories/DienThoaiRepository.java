package iuh.fit.se.be.repositories;

import iuh.fit.se.be.entities.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DienThoaiRepository extends JpaRepository<DienThoai, String> {
    List<DienThoai> findByNhaCungCap_MaNCC(String maNCC);
}
