package mx.developer.sp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.developer.sp.entity.Game;
import mx.developer.sp.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	GameService gameService;
	
	@GetMapping("")
	public ResponseEntity<Game> obtenerTodos(){
		List<Game> lista = gameService.getAll();
		return new ResponseEntity(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Game> obtenerUno(@PathVariable("id") int id){
		Optional<Game> game = gameService.getOne(id);
		return new ResponseEntity(game, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> guardar(@RequestBody Game game){
		gameService.saveGame(game);
		return new ResponseEntity("Game saved.", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Game> eliminar(@PathVariable("id") int id){
		gameService.deleteGame(id);
		return new ResponseEntity("Game deleted." ,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Game> actualizar(@PathVariable("id") int id, @RequestBody Game game){
		gameService.updateGame(id, game);
		return new ResponseEntity("Game updated.", HttpStatus.OK);
	}
	
}
