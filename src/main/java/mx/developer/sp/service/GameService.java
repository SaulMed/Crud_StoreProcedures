package mx.developer.sp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.developer.sp.entity.Game;
import mx.developer.sp.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;
	
	public List<Game> getAll(){
		return gameRepository.getAll_Procedure();
	}
	
	public Optional<Game> getOne(int id){
		return gameRepository.getOne_Procedure(id);
	}
	
	public void saveGame(Game game) {
		gameRepository.saveGame_Procedure(game.getTitle(), game.getGenere(), game.getPlatform(), game.getYear());
	}
	
	public void deleteGame(int id) {
		gameRepository.deleteGame_Procedure(id);
	}
	
	public void updateGame(int id, Game game){
		gameRepository.updateGame_Procedure(id , game.getTitle(), game.getGenere(), game.getPlatform(), game.getYear());
	}
	
}
