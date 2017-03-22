

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Community;



public interface CommunityRepository extends JpaRepository<Community,Long>{

	Community findByCif(String cif);
}
