package bankManagement.repository;

import bankManagement.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    @Query("select manager from Manager manager where manager.username=:username and manager.password=:password")
    public Manager login(@Param("username") String username, @Param("password") String password);
}

