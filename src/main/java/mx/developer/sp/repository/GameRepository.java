package mx.developer.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.developer.sp.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{
	
	@Query(value="{call storeProcedure_getAll()}", nativeQuery = true)
	List<Game> getAll_Procedure();

	@Query(value="{call storeProcedure_getOne(:idIn)}", nativeQuery = true)
	Optional<Game> getOne_Procedure(@Param("idIn") int idIn);
	
	@Query(value="{call storeProcedure_saveGame(:titleIn, :genereIn, :platformIn, :yearIn)}", nativeQuery= true)
	void saveGame_Procedure(
			@Param("titleIn") String titleIn,
			@Param("genereIn") String genereIn,
			@Param("platformIn") String platformIn,
			@Param("yearIn") int yearIn
			);
	
	@Query(value="{call storeProcedure_deleteGame(:idIn)}", nativeQuery=true)
	void deleteGame_Procedure(@Param("idIn") int idIn);
	
	@Query(value="{call storeProcedure_updateGame(:idIn, :titleIn, :genereIn, :platformIn, :yearIn)}", nativeQuery=true)
	void updateGame_Procedure(
			@Param("idIn") int idIn,
			@Param("titleIn") String titleIn,
			@Param("genereIn") String genereIn,
			@Param("platformIn") String platformIn,
			@Param("yearIn") int yearIn
			);
}
